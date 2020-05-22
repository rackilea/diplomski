.filter(new java.util.function.Predicate<SingularAttribute<MyEntity, ?>>() {
  @Override
  public boolean test(SingularAttribute<MyEntity, ?> a) {
      if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
          return true;
      } else {
          return false;
      }
  }
})