public static void printChars(char ch1, char ch2, int numberPerLine) {
     for (char i = ch1; i<ch2; i++) {
         System.out.printf("%c ", i);
         if((i-ch1) % numberPerLine == numberPerLine-1) {
              System.out.println("");
         }
     }        
}