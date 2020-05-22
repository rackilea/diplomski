String string = "Hello";

String subString1 = string.substring(1,4);             // ell
String subString2 = string.subSequence(1, 4);          // Type mismatch compiler error

CharSequence subSequence1 = string.subSequence(1, 4);  // ell
CharSequence subSequence2 = string.substring(1, 4);    // ell