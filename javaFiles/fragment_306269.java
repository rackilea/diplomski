public String multiply(String value, String binary) {
    String finalString = "";
    for (int i = 0; i < binary.length(); i++) {
        if (binary.charAt(i) == '1') {
            finalString+=value.charAt(i);
        }
    }       
    return finalString;

}