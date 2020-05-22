public static void main(String[] args) {
     int linenum = 0;
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
          String userInput =input.nextLine();
          String input1 = userInput.toLowerCase();
          for ( int i = 0; i < input1.length(); i++ ) {
             char ch=  input1.charAt(i);
             int value = (int) ch;
             if (value >= 97 && value <= 122){
             alphabetArray[ch-'a']++;
          }
        }
     int others= counts(++linenum, userInput); // THIS LINE CHANGE AND MOVED UP.
    countAllChars();
    String yesorno= anyVowels(userInput);
    String VowCont= countVowels (userInput);
    int Contcount= countConsonants(0, userInput);
    zeroLetterCount();
    System.out.print(" others="+others); // ADDED THIS LINE
    System.out.println();    
   }
}