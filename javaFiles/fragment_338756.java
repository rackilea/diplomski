public static String altCase(String text){
    StringBuilder result = new StringBuilder(text.toLowerCase());
    for(int i = 0; i < text.length(); i+= 2)
        result.setCharAt(i, Character.toUpperCase(text.charAt(i)));
    return result.toString();
}