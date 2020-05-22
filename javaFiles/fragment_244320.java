DynamicType.Builder<?> builder = ...
for ( ... ) {
  Class<?> type = ...
  String name = ...
  builder = builder.defineField(name, type, Visibility.PRIVATE)
                   .defineMethod("get" + name, type, Visibility.PUBLIC)
                   .intercept(FieldAccessor.ofBeanProperty())
                   .defineMethod("set" + name, void.class, Visibility.PUBLIC)
                   .withParameters(type)
                   .intercept(FieldAccessor.ofBeanProperty());
}