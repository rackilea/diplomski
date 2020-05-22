public static void mutate(String s, String t) {
    try {
        Field val = String.class.getDeclaredField("value"); 
        val.setAccessible(true); 
        char[] value = (char[]) val.get(s); 
        for (int i = 0; i < Math.min(s.length(), t.length()); i++)
            value[i] = t.charAt(i); 
    } 
    catch (Exception e) { e.printStackTrace(); }
}