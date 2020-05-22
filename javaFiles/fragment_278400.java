public static void main(String[] args) {
    Pattern pattern = Pattern.compile(":(?<!~:)");
    for (int runs = 0; runs < 4; ++runs) {
        long start = System.currentTimeMillis();
        for (int index = 0; index < 100000; ++index) {
            "This:string:must~:be:split:when:previous:char:is:not~:this".split(":(?<!~:)");
        }
        long stop = System.currentTimeMillis();
        System.out.println("Run: " + runs + " Regex: " + (stop - start));

        start = System.currentTimeMillis();
        for (int index = 0; index < 100000; ++index) {
            pattern.split("This:string:must~:be:split:when:previous:char:is:not~:this");
        }
        stop = System.currentTimeMillis();
        System.out.println("Run: " + runs + " Compiled Regex: " + (stop - start));

        start = System.currentTimeMillis();
        for (int index = 0; index < 100000; ++index) {
            specialSplit("This:string:must~:be:split:when:previous:char:is:not~:this");
        }
        stop = System.currentTimeMillis();
        System.out.println("Run: " + runs + " Custom: " + (stop - start));
    }

    for (String s : specialSplit("This:string:must~:be:split:when:previous:char:is:not~:this")) {
        System.out.println(s);
    }
}

public static String[] specialSplit(String text) {
    List<String> stringsAfterSplit = new ArrayList<String>();

    StringBuilder splitString = new StringBuilder();
    char previousChar = 0;
    for (int index = 0; index < text.length(); ++index) {
        char charAtIndex = text.charAt(index);
        if (charAtIndex == ':' && previousChar != '~') {
             stringsAfterSplit.add(splitString.toString());
             splitString.delete(0, splitString.length());
        } else {
                splitString.append(charAtIndex);
        }
            previousChar = charAtIndex;
    }
    if (splitString.length() > 0) {
        stringsAfterSplit.add(splitString.toString());
    }
    return stringsAfterSplit.toArray(new String[stringsAfterSplit.size()]);
}