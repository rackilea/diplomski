String someString = askFromUser();
try {
   int num = Integer.parseInt(someString);
   doSomethingWith(num);
} catch (NumberFormatException e) {
   complainAboutIt();
}