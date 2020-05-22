ArrayList<String> one = new ArrayList<String>();
for (int starti = 0; starti < one.size(); ++starti) {
    String[] words = one.get(starti).split(" ", 2);
    if (words[1].equals("<!----Begin---->")) {
        int n = 0;
        String sought = words[0] + " " + "<!----End---->";
        for (int endi = starti + 1; endi < one.size(); ++endi) {
            if (one.get(endi).equals(sought) {
                n = endi - starti;
                break;
            }
        }
        System.out.printf("%s at %d covers %d lines.%n", words[0], starti, n);
    }
}