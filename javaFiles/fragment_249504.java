public static Date asDate(String s) { 
    String[] dateStrings = s.split("/"); 
    int m = Integer.parseInt(dateStrings[0]); 
    int d = Integer.parseInt(dateStrings[1]); 
    int y = Integer.parseInt(dateStrings[2]); 
    return new Date(m, d, y);
}