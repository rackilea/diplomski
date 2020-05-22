public static List<String> descriptionFormatter(String str, int amt) {
    List<String> result = new ArrayList<>();

    // trim the input string to avoid empty strings at the end
    str = str.trim();

    int beginIndex = 0;  
    int endIndex = amt; 

    final int length = str.length();
    while(endIndex < length) {
        // if we landed on something other than space
        // increase the end index for the substring
        // until we hit a space
        while(endIndex < length && str.charAt(endIndex) != ' ') {
            ++endIndex;
        }
        result.add(str.substring(beginIndex, endIndex).trim());

        beginIndex = endIndex;
        endIndex += amt;
    }
    // Add the last string if any left
    if(beginIndex < length) {
        result.add(str.substring(beginIndex).trim());
    }
    return result;
}

public static void main(String[] args) {
    String str = "hello world apple orange grapes juice spagehtti sauce milk";
    descriptionFormatter(str, 34).forEach(System.out::println);
}