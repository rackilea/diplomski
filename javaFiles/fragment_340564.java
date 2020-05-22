final Field field = String.class.getDeclaredField("value");
   field.setAccessible(true);

   try {
       final char[] chars = (char[]) field.get(data);
       final int len = chars.length;
       for (int i = 0; i < len; i++) {
           if (chars[i] <= ' ') {
               doThrow();
           }
       }
       return len;
   } catch (Exception ex) {
       throw new RuntimeException(ex);
   }