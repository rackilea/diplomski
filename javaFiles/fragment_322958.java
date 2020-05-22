String input = userInput.toLowerCase();// Make your input toLowerCase.
    int[] alphabetArray = new int[26];
    for ( int i = 0; i < input.length(); i++ ) {
         char ch=  input.charAt(i);
         int value = (int) ch;
         if (value >= 97 && value <= 122){
         alphabetArray[ch-'a']++;
        }
    }