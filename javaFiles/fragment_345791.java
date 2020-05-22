static String ezDecrypt (String ezEncrypt){
    //this variable holds the value of the String's length
    int cl = ezEncrypt.length();

    //an array holding each character of the originally received text
    char[] chars = ezEncrypt.toCharArray();

    //temporary space for a lonely character
    char tempChar;

    //Do your swapping here
    if (ezEncrypt.length() % 2 == 0){ //Length is even
        //for loop that begins at 0
        //keeps looping until it reaches the end of the string
        //each loop adds 2 to the loop
        for(int i = 0; i < cl; i = i + 2) {
            tempChar = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = tempChar;
        }
    } else { //Length is odd
        //loop through and do the same process as above
        //except leave this loop will skip the last letter
        for(int i = 0; i < cl - 1; i = i + 2) {
            tempChar = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = tempChar;
        }
    }
    return new String(chars);
}