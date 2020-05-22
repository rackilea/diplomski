String windowSize = 5;
String text = "this is only a simple test. lorem impsum testing everything.";
String searchString = "test";
int i = -1;
while((i = text.indexOf(test, i + 1)) > -1)
{
    System.out.println(text.substring(i - windowSize, i + searchString.length() + windowSize));
}