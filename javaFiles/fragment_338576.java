if (argCount == 0) {
  if (name.startsWith(GET_PREFIX)) {
    // Simple getter
    pd = new PropertyDescriptor(this.beanClass, name.substring(3), method, null);
 } else if (resultType == boolean.class && name.startsWith(IS_PREFIX)) {
   // Boolean getter
   pd = new PropertyDescriptor(this.beanClass, name.substring(2), method, null);
 }
}

public static String decapitalize(String name) {
    if (name == null || name.length() == 0) {
        return name;
    }
    if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
                    Character.isUpperCase(name.charAt(0))){
        return name;
    }
    char chars[] = name.toCharArray();
    chars[0] = Character.toLowerCase(chars[0]);
    return new String(chars);
}