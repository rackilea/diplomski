System.out.println("Enter sentence that has to be translated into Pig Latin ");
  Scanner console = new Scanner(System.in);

  while (console.hasNextLine()) {
     String line = console.nextLine(); // get whole line
     String[] tokens = line.split("\\s+");  // split it on whitespace
     for (String token : tokens) {
        // process and print out each token
        System.out.print(processToken(token) + " ");
     }
     System.out.println();  // print out new line

     // check if line contains "exit"
     if (line.toLowerCase().contains(EXIT)) {
        break;
     }
  }
  if (console != null) {
     console.close();
  }