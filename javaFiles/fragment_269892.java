private static String getAppNameFromURL(String userEnteredURL){
    if(userEnteredURL!=null && !userEnteredURL.startsWith("/shirt")){
        return null;
    }
    Pattern p = Pattern.compile("^/shirt/([^?]([^\\?/]+|.*))");
    Matcher m = p.matcher(userEnteredURL);
    if(m.find()){
        return m.group(1);
    }
    return "";
}