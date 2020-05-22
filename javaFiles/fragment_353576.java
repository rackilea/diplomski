public static void main(String[] args) {
     String url = "http://localhost:8080/x?start=100&stop=1000";
     Pattern p = Pattern.compile(".*(start=[0-9]+).*");
     Matcher m = p.matcher(url);
     if ( m.find() ) {
         // m.group(0) - url
         // m.group(1) - the first group (in this case - it's unique) 
         System.out.println(m.group(1));
     }
}