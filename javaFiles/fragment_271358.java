String s1 = "java";
String s2 = "ja" + "va";
// "ja" appends to "va". As the compiler optimization pass realizes
// that "ja" + "va" is literal "java", it burns down the two strings into
// the same literal as s1.

String s3 = "ja";
String s4 = s3 + "va";
// s3 appends to "va". As the compiler cannot effectively study the literal,
// It is allowed to be concatenated at run-time. This allows "java" to be
// created from the heap, instead of from the common pool.