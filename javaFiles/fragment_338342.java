public static List<String> getAllMatches(String text, String regex) {
    List<String> matches = new ArrayList<String>();
    for(int length = 1; length <= text.length(); length++) {
        for(int index = 0; index <= text.length()-length; index++) {
            String sub = text.substring(index, index + length);
            if(sub.matches(regex)) {
                matches.add(sub);
            }
        }
    }
    return matches;
}