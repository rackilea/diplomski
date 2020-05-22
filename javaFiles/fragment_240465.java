public String copies(String s int n) {
    StringBuilder sb = new StringBuilder();
    if (n > 0) {
        int i = 0;
        while (i < n) {
           sb.append(s);
           i++;
        }
    }
    return sb.toString();
}