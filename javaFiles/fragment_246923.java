protected Factory<?> createValueFactory(Parameter parameter) {
   if (parameter.getRawType() == Dummy.class
       && parameter.isAnnotationPresent(MyAnnoation.class)) {
     return new MyFactory();
   }
   return null;
}