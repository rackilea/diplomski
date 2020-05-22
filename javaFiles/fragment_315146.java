String[] test = {"abcd", "abcdx"};
//                         | range
//                         |   | and
//                         |   | | new class excluding "x"
//                         |   | |    | adding quantifier for this example
Pattern p = Pattern.compile("[a-z&&[^x]]+");
for (String s: test) {
    System.out.println(p.matcher(s).matches());
}