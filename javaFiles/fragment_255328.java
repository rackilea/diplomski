String longString = "1234567890";
// backed by char[] of length 10

String substring = longString.substring(5);
// value is "67890", but still backed by the original char[] of length 10

String copy = new String(substring);
// also has value "67890", but now backed only by char[] of length 5