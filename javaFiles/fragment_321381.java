public enum Cardinals {
    NORTH("n", "north"),
    SOUTH("s", "south"),
    EAST("e", "east"),
    WEST("w", "west"),
    ERROR("", "");

    private final List<String> matchingStrings;

    Cardinals(String... matchingStringsAr) {
        this.matchingStrings = Arrays.asList(matchingStringsAr);
    }

    public static Cardinals formStr(String str){
        for (Cardinals cardinals : Cardinals.values()){
            if (cardinals.matchingStrings.contains(str)){
                return cardinals;
            }
        }
        return ERROR;
    }

}

// .....

Cardinals direction = Cardinals.formStr("n");