Collection<Entity> entities = Arrays.asList(new Entity(1, "one"), 
                  new Entity(11, "eleven"), new Entity(100, "one hundred"));
// get a collection of all the ids.
List<Long> ids = entities.stream()
                         .map(Entity::getId).collect(Collectors.toList());

System.out.println(ids);