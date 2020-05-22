public void decToAsci(String decimal) {
    String nb = "";
    for (int i = 0; i < decimal.length(); i++) {
        Character c = decimal.charAt(i);
        if (!c.equals(' ')) {
            nb += decimal.charAt(i);
            if (i == decimal.length() - 1)
                nb = processAsInt(nb);
        } else {
            nb = processAsInt(nb);
        }
    }
}

public String processInt(String nb) {
    int number = Integer.parseInt(nb);
    System.out.print((char) number + " ");
    return "";
}