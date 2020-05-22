// Let us define a new two-dimensional string array, with space for three elements:
String[][] our2dArray = new String[3][];

// Then, let us fill the array with values.
// We will add a String array with exactly one element (that element is `null` by chance)
our2dArray[0] = new String[] { null };

// We define the contents for index 1 of our2dArray
our2dArray[1] = new String[] { "a", "b", "c" };

// At last, the last element:
our2dArray[2] = new String[] { new String() };
// Which is effectively the same as
// new String[] { "" };