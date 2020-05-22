public String getStringOfLettersOnly(String s) {
    //using a StringBuilder instead of concatenate Strings
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
        if (Character.isLetter(s.charAt(i))) {
            //adding data into the StringBuilder
            sb.append(s.charAt(i));
        }
    }
    //return the String contained in the StringBuilder
    return sb.toString();
}