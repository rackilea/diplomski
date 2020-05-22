public static String filter(String str, String open, String close){
    int open_length = open.length();
    int close_length = close.length();

    StringBuilder s = new StringBuilder(str);
    StringBuilder filtered = new StringBuilder();

    for (int start = s.indexOf(open), end = s.indexOf(close, start + 1); start != -1; 
        start = s.indexOf(open), end = s.indexOf(close, start + 1)){
        filtered.append(s.substring(start + open_length, end)).append(", ");
        s.delete(0, end + close_length);
    }

    return filtered.substring(0, filtered.length() - 2); //trailing ", "
}