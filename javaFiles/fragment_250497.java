public static int defineItemAmount(NFItem[] parts, String item_pattern){
    System.out.println("STAMP2");
    Pattern pattern = Pattern.compile(item_pattern);
    int casecount = 0;
    for (NFItem part : parts) {
        if (testItem(part.plainname, pattern))
            ++casecount;
    }
    System.out.println("STAMP3");
    return casecount;
}

public static boolean testItem(String testString, Pattern pattern){
    Matcher m = pattern.matcher(testString);
    return m.matches();
}