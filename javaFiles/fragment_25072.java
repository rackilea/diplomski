public static String filter(String s, String open, String close){
    Pattern p = Pattern.compile(Pattern.quote(open) + "(.*?)" + Pattern.quote(close));
    Matcher m = p.matcher(s);

    StringBuilder filtered = new StringBuilder();

    while (m.find()){
        filtered.append(m.group(1)).append(", ");
    }
    return filtered.substring(0, filtered.length() - 2); //-2 because trailing ", "
}