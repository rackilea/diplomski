public static String[] tokenize (String str, char separator) {
    String sep = ""+separator;
    int max_size = str.length() - str.replace(sep, "").length() +1 ; // Calculate max array size
    String[] temp = new String[max_size];
    int start = 0, index = 0, exact_size = 0;
    int pos = str.indexOf(separator);
    while (pos>=start) {
        if (pos>start){
            temp[index++] = str.substring(start,pos).trim();
            exact_size++;
        }
        start = pos + 1;
        pos = str.indexOf(separator,start); 
    }
    String[] tokens = new String[exact_size];
    System.arraycopy(temp, 0, tokens, 0, exact_size); 
    return tokens;
}