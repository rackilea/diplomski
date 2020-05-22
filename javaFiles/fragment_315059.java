public static void main(String[] args) {
    String s1 = "REAL STEEL";
    String encoded = encode(s1, 3);
    System.out.println("Encoded the original " + s1 + " to be " + encoded);
    System.out.println("Decoded again to: " + decode(encoded,3));
}

static String encode(String input, int length) {
    String output = "";
    for(int i = 0;i<input.length();++i) {
        output += input.subSequence(i, i+length);
        if(i+length== input.length()) break;
    }
    return output;
}

static String decode(String input, int length) {
    String output = "";
    for(int i = 0;i<input.length();i+=length) {
        output +=input.charAt(i);
        if(i+length>=input.length())
            // Whenever the end was reached, the repeating has stopped
            // Here it just adds to the end of the output what is left.
            output += input.substring(i+1);
    }
    return output;
}