int openBrackets = 0;
ArrayList<String> tokens = new ArrayList<String>();
StringBuilder tmp = new StringBuilder();
for (int i = 0; i < inputString.length; ++i) {
   char cc = inputString.charAt(i);
   if (cc == '(') openBrackets++;
   else if (cc == ')') openBrackets--;
   else if ((cc == ',') && (openBrackets == 0)) {
      tokens.add(tmp.toString());
      tmp.delete(0, tmp.length());
   }
   else tmp.append(cc);
}
if (tmp.length() > 0) tokens.add(tmp.toString());