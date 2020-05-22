protected void processLine(String aLine) {
   if (aLine.trim().equals("")) {
       System.out.println();//executed when an empty line is read
   }
   else if (aLine.startsWith("#*")) {
      System.out.println("Title:" + aLine.substring(2)); //or, you can also do
      //System.out.println("Title:" + aLine.substring("#*".length()));
   } else if (aLine.startsWith("otherCases") {
      //proceed for other cases in similar fashion.
   }
   .
   .
   .
}