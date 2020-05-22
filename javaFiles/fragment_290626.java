Map<String, Set<SomeObject>> map = contexts.stream()
    .collect(Collectors.toMap(Context::getUserid, 
       c -> c.getSomeObjects().values().stream()
      .flatMap(Collection::stream)
      .collect(Collectors.toSet())
     ));