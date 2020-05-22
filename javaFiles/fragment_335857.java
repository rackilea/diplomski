boolean shouldPrint = false;
while (scanner.hasNextLine()) {
   String line = scanner.nextLine();

   if (line.startsWith("on Thursday)") {
     shouldPrint = true;
   } else if (line.startsWith("3  3") {
     shouldPrint = false;
   }

   if(shouldPrint) writer.write(line);
}