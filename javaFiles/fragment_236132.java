Map<String, Map<String,String>> parse(String input){
    HashMap<String, Map<String, String>> variables = new HashMap<>();
    Matcher variableMatcher = Pattern.compile("variable \"(\\S+?)\"\\s*\\{\\s*((?:.|\\n)+?)\\s*}").matcher(input);
    Pattern bodyElementPattern = Pattern.compile("(\\S+)\\s*=\\s*\"(.+)\"");
    while (variableMatcher.find()){
        HashMap<String, String> bodyElements = new HashMap<>();
        Matcher bodyElementMatcher = bodyElementPattern.matcher(variableMatcher.group(2));
        while (bodyElementMatcher.find()){
            bodyElements.put(bodyElementMatcher.group(1),bodyElementMatcher.group(2));
        }
        variables.put(variableMatcher.group(1),bodyElements);
    }
    return variables;
}