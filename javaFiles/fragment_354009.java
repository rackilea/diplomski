String FNAME[] = new String[1];
FNAME[0] = "John Dor";

System.out.println("FNAME #1: " + FNAME[0]); // prints John Dor

// Using replace to change letter
FNAME[0] = FNAME[0].replace('r', 'e');

System.out.println("FNAME #2: " + FNAME[0]); // prints John Doe

// Replacing with completely new string
FNAME[0] = "John Dor";

System.out.println("FNAME #3: " + FNAME[0]); // prints John Dor

FNAME[0] = "John Doe";

System.out.println("FNAME #4: " + FNAME[0]); // prints John Doe