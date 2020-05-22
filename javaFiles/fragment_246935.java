String test = "all lower case";
if (test == test.toLowerCase()) {
  System.out.println("The strings are the same object, " + 
      "so toLowerCase performs a check before allocating a new one.");
} else {
  System.out.println("A new string object is created even when not needed.");
}