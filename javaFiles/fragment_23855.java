public static double tryParsDouble(String s, double defaultValue) {
     if (s == null) return defaultValue;

     try {
         return Double.parseDouble(s);
     } catch (NumberFormatException x) {
         return defaultValue;
     }  
}