public static String escapeSolrQuery(String searchWord){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
          char c = searchWord.charAt(i);

          if (c == '\\' || c == '+' || c == '-' || c == '!'  || c == '(' || c == ')' || c == ':'
            || c == '^' || c == '[' || c == ']' || c == '{' || c == '}' || c == '~'
            || c == '*' || c == '?' || c == '|' || c == '&'  || c == ';' || c == '/') 
          {
            sb.append('\\');
          }

          if(c == '\"' && !searchWord.matches("\"[^\"]+\"")){
              sb.append('\\');
          }
          sb.append(c);
        }
       return sb.toString();
    }