public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    for(String s : args) {
        sb.append(s);
        sb.append(" "); //some length of whitespace
    }

    String yourString = sb.toString().trim();
}