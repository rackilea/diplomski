public enum Token {

   FOO("foo", "f"),
   BAR("bar", "b");

   private String keyword;
   private String abbreviation;

   private Token(String keyword, String abbreviation) {
       this.keyword = keyword;
       this.abbreviation = abbreviation;
   }

   public String getKeyword() { 
       return this.keyword; 
   }
   public String getAbbreviation() { 
       return this.abbreviation;
   }

   public static Token valueOf(String s) {
       for (Token token : values()) {
           if (token.getKeyword().equals(s) || token.getAbbreviation().equals(s)) {
               return token;
           }
       }
       throw new IllegalArgumentException("No such keyword:  " + s);
   }
}