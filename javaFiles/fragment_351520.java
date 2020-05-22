public static String transliterate(String srcstring) {
    ArrayList<String> copyTo = new ArrayList<String>();

    String cyrcodes = "";
    for (int i=1040;i<=1067;i++) {
        cyrcodes = cyrcodes + (char)i;
    }
    for (int j=1072;j<=1099;j++) {
        cyrcodes = cyrcodes + (char)j;
    }
    // Uppercase
    copyTo.add("A");
    copyTo.add("B");
    copyTo.add("V");
    copyTo.add("G");
    copyTo.add("D");
    copyTo.add("E");
    copyTo.add("Zh");
    copyTo.add("Z");
    copyTo.add("I");
    copyTo.add("I");
    copyTo.add("K");
    copyTo.add("L");
    copyTo.add("M");
    copyTo.add("N");
    copyTo.add("O");
    copyTo.add("P");
    copyTo.add("R");
    copyTo.add("S");
    copyTo.add("T");
    copyTo.add("U");
    copyTo.add("F");
    copyTo.add("Kh");
    copyTo.add("TS");
    copyTo.add("Ch");
    copyTo.add("Sh");
    copyTo.add("Shch");
    copyTo.add("");
    copyTo.add("Y");

    // lowercase
    copyTo.add("a");
    copyTo.add("b");
    copyTo.add("v");
    copyTo.add("g");
    copyTo.add("d");
    copyTo.add("e");
    copyTo.add("zh");
    copyTo.add("z");
    copyTo.add("i");
    copyTo.add("i");
    copyTo.add("k");
    copyTo.add("l");
    copyTo.add("m");
    copyTo.add("n");
    copyTo.add("o");
    copyTo.add("p");
    copyTo.add("r");
    copyTo.add("s");
    copyTo.add("t");
    copyTo.add("u");
    copyTo.add("f");
    copyTo.add("kh");
    copyTo.add("ts");
    copyTo.add("ch");
    copyTo.add("sh");
    copyTo.add("shch");
    copyTo.add("");
    copyTo.add("y");        

    String newstring = "";
    char onechar;
    int replacewith;
    for (int j=0; j<srcstring.length();j++) {
        onechar = srcstring.charAt(j);
        replacewith = cyrcodes.indexOf((int)onechar);
        if (replacewith > -1) {
            newstring = newstring + copyTo.get(replacewith);
        } else {
            // keep the original character, not in replace list
            newstring = newstring + String.valueOf(onechar);
        }
    }

    return newstring;
}