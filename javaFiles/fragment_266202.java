while(scanner.hasNext()) {
   String lineOfText = scanner.nextLine();
   if (lineOfText.startsWith("//") || lineOfText.startsWith(" ")) {
      continue; //Exit this iteration if line starts with space or /
   }
   System.out.println(lineOfText);
}