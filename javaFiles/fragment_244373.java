public static int decode(String roman) {
    int result = 0;
    String uRoman = roman; //case-insensitive
    int prevPart = -1;
    for(int i = 0; i < uRoman.length(); i++) {//loop over all but the last character
        int curPart = 0;
        int letter = (int)uRoman.charAt(i);
        if (letter >= 'a' && letter <= 'z')
            letter -= (int)'a' - (int)'A';  // toUpper emulation
        if (letter <= (int)'I') {
            if (letter == (int)'C') {
                curPart = 100;
            } else if (letter == (int)'D') {
                curPart = 500;
            } else if (letter == (int)'I') {
                curPart = 1;
            }
        } else if (letter <= (int)'M') {
            if (letter == (int)'L') {
                curPart = 50;
            } else if (letter == (int)'M') {
                curPart = 1000;
            }
        } else if (letter == (int)'V') {
            curPart = 5;
        } else if (letter == (int)'X') { 
            curPart = 10;
        }
        if (prevPart > 0) {
            //if this character has a lower value than the next character
            if (prevPart < curPart) {
                //subtract it
                result -= prevPart;
            } else {
                //add it
                result += prevPart;
            }
        }
        prevPart = curPart;
    }
    //decode the last character, which is always added
    result += prevPart;
    return result;
}