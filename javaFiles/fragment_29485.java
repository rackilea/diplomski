String str = arr[i];
char[] letters = str.toCharArray();

boolean secondLetterIsVowel = letters[1] == 'a'
                           || letters[1] == 'e'
                           || letters[1] == 'i'
                           || letters[1] == 'o'
                           || letters[1] == 'u';
for(char letter : letters) {
    if(secondLetterIsVowel) {
        inputField.append(" \n" + letter);
    }
    //...
}