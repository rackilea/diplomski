private static final int INITIAL_SIZE = 10;
   private static final int INCREMENT = 5;

   String[] lines = new String[INITIAL_SIZE];
   int amountOfLinesRead = 0;

   // loop until end of file
     // read line
     if(amountOfLinesRead == lines.length) {
       lines = resizeArray(lines);
     }
     lines[amountOfLinesRead++] = line;

   public String[] resizeArray(final String[] originalArray) {
     // create bigger array
     String[] newArray = new String[originalArray.length + INCREMENT];
     // copy array
     for(int amountOfLinesCopied = 0; amountOfLinesCopied < originalArrayString.length ; amountOfLinesCopied++) {
       newArray[amountOfLinesCopied] = originalArray[amountOfLinesCopied];
     }
     return newArray;
   }