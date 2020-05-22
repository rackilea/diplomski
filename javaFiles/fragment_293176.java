public static void main(String[] args) {
  System.out.println(formatOutput("Hello", "How are you?", "Wassup"));
}

public static String formatOutput(String textA, String textB, String textC) {
    StringBuilder output = new StringBuilder("");

    int beginIndex = 0, endIndex = 3;
    String snippet;
    while (textA.length() > 0 || textB.length() > 0 || textC.length() > 0) {
        if (textA.length() > endIndex) {
            snippet = textA.substring(beginIndex, endIndex);
            textA = textA.substring(endIndex);
        } else {
            snippet = textA.substring(beginIndex);
            textA = "";
        }
        output.append(snippet);
        for (int i = snippet.length(); i <= 8; i++)
            output.append(" ");
        ;

        if (textB.length() > endIndex) {
            snippet = textB.substring(beginIndex, endIndex);
            textB = textB.substring(endIndex);
        } else {
            snippet = textB.substring(beginIndex);
            textB = "";
        }
        output.append(snippet);
        for (int i = snippet.length(); i <= 8; i++)
            output.append(" ");


        if (textC.length() > endIndex) {
            snippet = textC.substring(beginIndex, endIndex);
            textC = textC.substring(endIndex);
        } else {
            snippet = textC.substring(beginIndex);
            textC = "";
        }
        output.append(snippet);
        for (int i = snippet.length(); i <= 3; i++)
            output.append(" ");
        output.append("\n");    
    }
    return output.toString();
}