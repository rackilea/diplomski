public String printMatrix(String s [][]){
    String keyOut = "  J A V A\n";
    for (int i = 0; i < s.length; i++) {
        keyOut += PHRASE_KEY[i] + " ";
        for (int j = 0; j < s[i].length; j++) {
            keyOut += s[i][j] + " ";
        }
        keyOut += "\n";
    }
    return keyOut;
}