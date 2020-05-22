//                | preceded by digit
//                |      | one whitespace
//                |      |   | followed by non-digit
//                |      |   |      | OR
//                |      |   |      | | preceded by non-digit
//                |      |   |      | |      | one whitespace
//                |      |   |      | |      |   | followed by digit
String pattern = "(?<=\\d)\\s(?=\\D)|(?<=\\D)\\s(?=\\d)";
// test Strings
String test0 = "word 123";
String test1 = "123 word";
String test2 = "world 123 wide";
String test3 = "world wide 123";
String test4 = "world wide 123 456";
// testing output: replace all found matches
// (e.g. one per String in this case)
// with empty
System.out.println(test0.replaceAll(pattern, ""));
System.out.println(test1.replaceAll(pattern, ""));
System.out.println(test2.replaceAll(pattern, ""));
System.out.println(test3.replaceAll(pattern, ""));
System.out.println(test4.replaceAll(pattern, ""));