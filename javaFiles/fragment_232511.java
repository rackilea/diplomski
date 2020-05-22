int startIndex = 12;
int length = 34;
String s = string.substringByIndices(startIndex, startIndex+length);

// One would expect this to yield "true". If the end index
// was inclusive, this would not be the case...
System.out.println(s.length() == length);