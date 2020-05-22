Optional<Entity> result = FluentIterable.from(entityList).firstMatch(new Predicate<Entity>() {
  @Override
  public boolean apply(Entity entity) {
    return entity.getName().equals(input);  //Input can be from variable in function definition
  });
);