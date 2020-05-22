class Split {
    public static void main (String[] args) {
        String in = "if (com.google.code) then";
        Pattern p = Pattern.compile("(\\w+)(\\))");
        Matcher m = p.matcher(in);
        if(m.find()) 
            in = m.group(1);
        System.out.println(in); // or whatever
    }
}