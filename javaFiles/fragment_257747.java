public static String getSandwich(String str) {
    int ind = str.indexOf("bread");
    int laind = str.lastIndexOf("bread");
    if((laind != -1 ) && (ind!=laind))
        return (str.substring(ind+5,laind)) ;
    return "";
}