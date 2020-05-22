while((line = readLine()) != null) {
   String[] values = line.split(":");
   if (values.length != 4) {
       System.out.println("bad line: " + line);
   }
   // check for empty fields like:
   if (values[0].isEmpty()) {/* error message */}
   // check for proper numeric values like:
   try {
       // prob need to remove leading whitespace as well...
       Integer.parseInt(values[2].trim());
   } catch (NumberFormatException e) {/* error message */}
   // etc...
}