public String missingChar(String str, int n) {
    if (n < str.length()){
        String a = str.substring(0,n);
        String b = str.substring(n+1, str.length());
        return a + b;
    } 
    return str;
}