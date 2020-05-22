public static String removeUnicode(String input){
    StringBuffer buffer = new StringBuffer(input.length());
    for (int i =0; i < input.length(); i++){
        if ((int)input.charAt(i) > 256){
        buffer.append("\\u").append(Integer.toHexString((int)input.charAt(i)));
        } else {
            if ( input.charAt(i) == '\n'){
                buffer.append("\\n");
            } else {
                buffer.append(input.charAt(i));
            }
        }
    }
    return buffer.toString();
}