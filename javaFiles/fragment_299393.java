public static void main(String[] args) {
            int counter2 =0;
            String acc = JOptionPane.showInputDialog("Enter a string:");
            String[] words = acc.split(" ");
            int wordsWithVowels = 0;
            for(String word : words){
              int counter =0;
              int sum=0;
              word = word.toLowerCase();
              for (int i =0; i < word.length(); i++){ 
                 char x = word.charAt(i);
                 if(x == 'a' || x == 'e' || x == 'i' ||
                    x == 'o' || x == 'u'){
                     counter++;
                  }

              } // end of inner for loop
             if (counter >= 2) {
                wordsWithVowels++;
             }  
          } // // end of outer for loop
      System.out.println("Number of words with 2 or more vowels "+wordsWithVowels);
     } // end of main