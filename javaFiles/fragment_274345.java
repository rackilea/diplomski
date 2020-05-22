Map<String,List<String>> map =
    userList.stream()
            .flatMap(user -> {
                Map<String,String> um = new HashMap<>();
                um.put("names",user.getName());
                um.put("age",user.getAge());
                um.put("org",user.getOrg());
                return um.entrySet().stream();
            }) // produces a Stream<Map.Entry<String,String>>
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                                           Collectors.mapping(Map.Entry::getValue,
                                                              Collectors.toList())));