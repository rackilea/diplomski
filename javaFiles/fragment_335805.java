Matcher webMatcher = Patterns.WEB_URL.matcher(input);
ArrayList<String> veridocLinks = new arrayList<>();
ArrayList<String> otherLinks = new arrayList<>();

while (webMatcher.find()){
    String res = webMatcher.group();
    if(res!= null) {
        if(res.contains("veridoc")) veridocLinks.add(res);
        else otherLinks.add(res);
    }
}