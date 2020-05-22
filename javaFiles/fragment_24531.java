public void decToAsci(String decimal) {
    String nb = "";
    for (int i = 0; i < decimal.length(); i++) {
        Character c = decimal.charAt(i);
        if (!c.equals(' ')) {
            nb += decimal.charAt(i);
        }
        if (c.equals(' ') || i == decimal.length() - 1) {
            int number = Integer.parseInt(nb);
            System.out.print((char) number + " ");
            nb = "";
        }
    }
}