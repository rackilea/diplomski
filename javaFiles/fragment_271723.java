public static void main(String[] args) {
   String s = "@hello.com\n#howAreyouthisday.com\nhello how are you\n@hellowithnoending";
   String all[] = s.split("\\s+");
   List<String> allMatches = new ArrayList<>();
   for(String e : all) {           
       //This regular expression(regex) is looking at the String e
       //to start with either @ or #, as well as end in .com
       if(e.matches("^(@|#).*(\\.com)$")) {
           allMatches.add(e);

       }
   }
   System.out.println("Results:");
   for(String x : allMatches) {
       System.out.println(x);
   }
}