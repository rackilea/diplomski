public static String filter(String s, String open, String close){
    int start = s.indexOf(open);
    int end = s.indexOf(close, start + 1);

    //I took the liberty of adding "String" and renaming your variable
    String get = s.substring(start + open.length(), end);
    s = s.substring(end + close.length());

    if (s.indexOf(open) == -1){
        return get;
    }
    return get + ", " + filter(s, open, close);
}