String TestInput = "In THE house BIG BLACK cat is very good.";
    Pattern p = Pattern
            .compile(
                    "(?<=\\b\\p{Lu}+\\s)  # lookbehind assertion to ensure a uppercase word before\n"
                            + "\\p{L}+    # matching at least one letter\n" 
                            + "(?=\\sis)  # lookahead assertion to ensure a whitespace is ahead\n"
                            , Pattern.COMMENTS);    Matcher m = p.matcher(TestInput);
if(m.find())
    System.out.println(m.group(0));