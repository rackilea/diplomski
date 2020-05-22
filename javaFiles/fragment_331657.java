list.parallelStream()
    .filter(id -> {
       Person person = map.get(id);
       return person != null && !Strings.isNullOrEmpty(person.getName());
     })
    .collect(Collectors.toList());