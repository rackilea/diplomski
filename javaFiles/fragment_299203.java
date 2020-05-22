boolean correctFormat = false;
do {
   // ask the user for input
   // read the input
   try {
       // try to format the input
       correctFormat = true;
   } catch (ParseException e) {
       correctFormat = false;
   }
} while (!correctFormat);