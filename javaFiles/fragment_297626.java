String test = "test12";
String subtest;
//long version
if(test.length() > 8){
      subtest = test.substring(1, 8);
} else {
      subtest = test.substring(1, test.length());
}
//short version
subtest = test.substring(1, test.length() > 8 ? 8 : test.length());
System.out.println(subtest); //Output: est12