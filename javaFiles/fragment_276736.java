int [] ia; // only declares the array as of type int
int [] ia = new int [4]; // +size =4, all elements are 0
int [] ia = new int [] {3, 4, 5}; /* elements defined, and 
  size is implicitly set to 3 */
String [] sa; // only declared, type defined
String [] sa = new String [4]; /* type and size defined
  but no elements, no strings defined */
String [] sa = new String [] {new String ("exit")}; /* type defined, size implicitly (1), one element= String defined, using a constructor */