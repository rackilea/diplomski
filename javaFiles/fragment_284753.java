String input = "part1+250+|part2|+part3";

Pattern p = 
//                   | group 1 ("variable")
//                   | | positive look behind for "|"
//                   | |      | character class for allowed characters
//                   | |      |             | quantifier for 1+ instance, greedy
//                   | |      |             | | positive lookahead for "|"
//                   | |      |             | |      | OR
//                   | |      |             | |      || group 2 ("constant") 
//                   | |      |             | |      ||| negative lookbehind for "|"
//                   | |      |             | |      |||       | allowed chars
//                   | |      |             | |      |||       |             | quantifier
//                   | |      |             | |      |||       |             | | negative
//                   | |      |             | |      |||       |             | | lookahead
//                   | |      |             | |      |||       |             | | 
    Pattern.compile("((?<=\\|)[ a-zA-Z0-9_-]+(?=\\|))|((?<!\\|)[ a-zA-Z0-9_-]+(?!\\|))");
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.printf("Variable: %s%nConstant: %s%n", m.group(1), m.group(2));
}