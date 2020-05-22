public static String replicate(String str, int times) {
    String newString = "";
    for (int i = 0; i < times; i++) {
        newString = newString + str;
        if(i<times-1){
            newString = newString + ", ";
        }
    }
    return newString;
}