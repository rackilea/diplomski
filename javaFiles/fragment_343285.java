public static <E extends Enum<E>>
String getEnumString(Class<E> clazz, String s){
  for(E en : EnumSet.allOf(clazz)){
    if(en.name().equalsIgnoreCase(s)){
      return en.name();
    }
  }
  return null;
}