Material m = ...;
Stream.of(Material.class.getDeclaredFields())
      .map(field -> "get" + ucFirst(field.getName()))
      .map(getterName -> Material.class.getMethod(getterName))
      .map(getterMethod -> getterMethod.invoke(m))
      .forEach(fieldValue -> {
            //do something
      });

...
private String ucFirst(String input) {
    if(input.length() <= 1){
        return input.toUpperCase();
    }
    return input.substring(0, 1).toUpperCase() + input.substring(1);
}