// Get first, middle initial, and last name from the string
String nameParts [] = name.split(" ");
// not sure if you need these variables, but I guess you get the picture
first = nameParts [0];
middle = nameParts [1];
last = nameParts [2];
middleInital = middle.charAt(0);

// Output formatted name as "Last, First MI."
System.out.println(last + ", " + first + " " + middleInital + ".");