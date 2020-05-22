static String decode(String input, int length) {
    String output = "";
    for(int i = 0;i<input.length();i+=length) {
        output +=input.charAt(i);
        if(i+length>=input.length())
            output += input.substring(i+1);
    }
    return output;
}