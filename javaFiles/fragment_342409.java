public String getHex(String binary) {
    StringBuilder hexBuilder = new StringBuilder();
    int startIndex = 0;
    int endIndex = 4;
    while(true) {
        hexBuilder.append(getHex(binary.substring(startIndex, endIndex)));
        // Irrelevant
    }
    // Irrelevant
}