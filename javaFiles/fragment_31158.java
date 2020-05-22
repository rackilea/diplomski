public String formattedLine(String singleLine, int limit) {
    int padding = limit - singleLine.length();
    String pad ="";
    for(int j = 0; j < padding; j ++) {
        pad += " ";
    }
    return  "[" + singleLine + pad + "]\n";
}

public String leftTextFormat(String text, int limit) {
    String word = "";
    String singleLine = "";
    String formattedText = "";
    for(int i=0; i<text.length(); i++) {
        if (text.charAt(i) != ' ') {
            word = word + text.charAt(i);
        } else {
            if(word.length() > 0) {
                if(singleLine.length() + word.length() >= limit) {
                  formattedText = formattedText + formattedLine(singleLine, limit);
                  singleLine = "";
                }
                if(singleLine.length() == 0) {
                    singleLine = word;
                } else {
                    singleLine = singleLine + " " + word;
                }
                word = "";
            }
        }
    }
    formattedText = formattedText + formattedLine(singleLine, limit);
    return formattedText;
}