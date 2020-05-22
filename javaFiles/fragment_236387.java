public static String repeatChar(char repeatChar, int repeatTimes) {
    String result = "";
    for(int j = 0; j < repeatTimes; j++) {
        result += repeatChar;
    }
    return result;
}