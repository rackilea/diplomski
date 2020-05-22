Map<String,List<A>> map = new HashMap<>();
    myGroups.forEach(g -> {
        aList.stream().filter(a -> a.getGroups().contains(g)).forEach(a ->{
            map.computeIfAbsent(g, s -> new ArrayList<>()).add(a);
        });
    });