String myString = new String("This is a string!"); // Normally I wouldn't allocate a string here, but just for the parallel structure we will.
System.out.println(myString.length());

/* Reassign myString to point to a different string object. */
myString = new String("Here's another string!");
System.out.println(myString.length());