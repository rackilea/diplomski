// Concatenation
String a = "a";
String b = "b";

a = a + b;

// It's equivalent once it's compiled
String a = "a";
String b = "b";

StringBuilder aBuilder = new StringBuilder(a);
aBuilder.append(b);
a = aBuilder.toString();