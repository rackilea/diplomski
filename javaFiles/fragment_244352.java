public static String insertMessage(String s, int x){
    String result;
    if (count < binarizedMessage.length()) {
        result = clearLSB(s, x);
    } else {
        result = s;
    }
    StringBuilder temp = new StringBuilder(result);

    for (int i = 8 - x; i < 8; i++){
        if(count < binarizedMessage.length())
            temp.setCharAt(i, binarizedMessage.charAt(count++));           
    }

    return temp.toString();
}