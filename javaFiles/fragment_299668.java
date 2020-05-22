public static Element parse(String s) {
     // ...
     char[] c = s.toCharArray();
     int brackets = 0;
     for (int i = 0; i < c.length(); i++) {
          if (c[i] == '(') brackets++;
          else if (c[i] == ')') brackets--;
          else if (c[i] == '/' && brackets == 0) return new FractionElement();
     }
     // ...
     return new OperatorElement();
}