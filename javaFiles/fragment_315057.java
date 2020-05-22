// The used length should be 3;
String encode(String input, int length) {
    String output = "";
    for(int i = 0;i<input.length();++i) {
        output += input.subSequence(i, i+length);
        if(i+length== input.length()) break;
    }
    return output;
}