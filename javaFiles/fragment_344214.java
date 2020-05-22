public static String checkPhrase(String cleverPhrase) {
    int len = cleverPhrase.length();
    String output = "";

    for (int i = 0; i <= len; i++) {
        char current = cleverPhrase.charAt(i);
        if (Character.isLetter(current)) {
            if (current == 'A' || current == 'B' || current == 'C') {
                output += "2";
            } else if (current == 'D' || current == 'E' || current == 'F') {
                output += "3";
            } else if (...) {
                ....
            }
        }
        if(output.length()==3){
            output += "-";
        }
    }

    if(output.isEmpty()){
        output = "No phone number";
    }else if(output.length()!=8){
        output = "Not a valid number";
    }
    return output;
}