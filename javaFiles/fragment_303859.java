String s = "√(A&(B&C))=(|C| & (! D))";

Matcher m = Pattern.compile("("
  +  "[^\\s=]?\\(" // capture opening bracket with modifier (if any)
                   // you can replace it with "[√]?\\(", if only
                   // "√" symbol should go in conjunction with brace
  + "|\\)"         // capture closing bracket
  + "|\\w"         // capture identifiers
  + "|[=!\\&\\|]"  // capture symbols "=", "!", "&" and "|"
  + ")").matcher(s.replaceAll("\\s", ""));

ArrayList<String> r = new ArrayList<>();
while(m.find())
  r.add(m.group(1));

    System.out.printf("%s -> %s\n", s, r.toString().replaceAll(", ", ",")); // ArrayList joins it's elements with ", ", so, removing extra space