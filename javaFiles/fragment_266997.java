public static void main(String[] args) throws Exception {
  Object o = new X();

  for (Field field : o.getClass().getFields()) {
     if (!Serializable.class.isAssignableFrom(field.getType())) {
        System.out.println("Field " + field + " is not assignable from type " + o.getClass());
     }
  }