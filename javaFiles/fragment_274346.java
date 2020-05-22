Map<String,List<String>> map =
    userList.stream()
            .flatMap (user -> Stream.of (new SimpleEntry<>("names",user.getName()),
                                         new SimpleEntry<>("age",user.getAge()),
                                         new SimpleEntry<>("org",user.getOrg())))
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                                           Collectors.mapping(Map.Entry::getValue,
                                                              Collectors.toList())));