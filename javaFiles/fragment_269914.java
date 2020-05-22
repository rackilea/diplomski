public static String runEven(String string) {
     char[] array =  runEvenImpl(string.toCharArray(), 0, string.length());
     return new String(array);
}

public static char[] revEvenImpl(char[] array, int head, int tail) {
      if (head == tail)
         return array;
      if (head % 2 == 0 && tail % 2 == 0)
      {
           swap(array, head, tail);
      }
      revEven(array, head+1, tail-1);
   }