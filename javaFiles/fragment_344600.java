public static void printChars(char ch1, char ch2, int numberPerLine) {
        int count=1;
        for (int i = ch1; i <= ch2; i++) { 
            if (count == numberPerLine) { 
                System.out.println((char) i);count=0;//reset counter
            }
            else {
                System.out.print((char) i + " ");count++;//increment counter
            }
         }
       }