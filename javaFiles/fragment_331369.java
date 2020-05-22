static public List<String> collect(String str) {
    List<String> list = new ArrayList<String>();
    Pattern p = Pattern.compile("\\[.+?\\]");
    Matcher m = p.matcher(str);
    while (m.find())
        list.add(m.group());
    return list;
}