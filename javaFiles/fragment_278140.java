void createTool(Class<? extends Tool> clazz) { // allow Tool and its subtypes
  // subtypes should have constructors matching this signature  
  Tool tool = clazz.getConstructor(String.class,double.class,double.class)
                   .newInstance("name", weight,length);
  // deal with exceptions...
 }