String getClass(String command) {
    String returnStr;
    for (int i = 0; i < 3; i++) {
        returnStr += command[i+1];
    }

    return returnStr;
}