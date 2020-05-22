public String extractWhileLoop(String text) {
    extractedThis = "";

    while(text.length() > 0) {
        extractedThis += text.charAt(0);
        text = text.substring(1);
    }
    return extractedThis;
}

public String extractForLoop(String text) {
    extractedThis = "";
    for (int i = 0; i < text.length(); i++) {

        extractedThis += text.charAt(i);
    }

    return extractedThis;
}