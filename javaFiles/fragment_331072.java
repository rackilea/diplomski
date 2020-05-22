public static String readFromStandardIO() {
   StringBuilder returnValue = new StringBuilder(9999999);
   try {
       BufferedReader reader = new BufferedReader(System.in);
       String userInput;
       while ((userInput = reader.readLine()) != null) {
          returnValue.append(userInput);
       }
       reader.close();
   } catch (Exception e) {

   }
   return returnValue.toString();
}