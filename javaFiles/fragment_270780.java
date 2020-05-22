final static String COMMA = ", ";
  public static String replicate(String s, int count) {
      String answer = "";
      if(count <= 2) {
        return answer;
      }
      if(count == 3) {
        return (s + COMMA + s + COMMA + s);
      }
      else {
          answer = s + COMMA + replicate(s, (count - 1));
          return answer;
      }
  }