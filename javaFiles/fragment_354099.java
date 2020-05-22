String test = "(\"test1\", \"test2\") (\"test3\", \"test4\")";
final String regex = "(^\\(|\\G(?!^),\\h*)\"([^\"]+)\"";

test = test.replaceAll(regex, "$1'$2'");
System.out.println(test);
//=> ('test1', 'test2') ("test3", "test4")