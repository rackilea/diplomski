class OptionalAwareObjectFactory extends DefaultObjectFactory {

  public Object create(Class type, List<Class> constructorArgTypes, List<Object> constructorArgs) {
     if (Optional.class.isAssignableFrom(type)) {
        return Optional.fromNullable(Iterables.getOnlyElement(constructorArgs));
     } else {
        return super.create(type, constructorArgTypes, constructorArgs);
     }
  }
}