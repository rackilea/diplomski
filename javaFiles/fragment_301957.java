class Statics {
  public static String LOC_MY_SELECTOR;

  public Statics() {
    Field[] fields = getClass().getDeclaredFields();

    for (Field field : fields) {
      int mods = field.getModifiers();
      if (field.getType() == String.class &&
        !Modifier.isFinal(mods) &&
        Modifier.isStatic(mods) &&
        Modifier.isPublic(mods) &&
        field.getName().startsWith("LOC_")
      ) {

        String fieldName = field.getName();
        field.setAccessible(true);

        try {
          // homepage_
          String translation = fieldName.split("_", 2)[1].toLowerCase();

          field.set(field, translation);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }

  static void find(String selector) {
    System.out.println(selector);
  }  

  public static void main(String...args) {
    find(LOC_MY_SELECTOR);
    // will print "my_selector" now
  }
}