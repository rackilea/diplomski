public Double getValue(String name){
    Pattern p = Pattern.compile("(?<=" + name + "\\()\\d+\\.\\d+(?=\\))");
    Matcher m = p.matcher("<your matcher string>");
    m.find();
    return Double.parseDouble(m.group());
}