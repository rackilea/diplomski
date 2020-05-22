//String representing pathway
  String sokvag1, sokvag2, sokvag3;

  //Creating scanner object for reading from input stream 
  Scanner userInput = new Scanner(System.in);

  // Set delimiter to ':' or '/' or whitespace
  userInput.useDelimiter("[:/\\s]+"); 

  // Instructions to the user to type a windows patway ex: C://Windows/System/
  System.out.print("Skriv in sökvägen: ");

  //Input
  sokvag1 = userInput.next();
  sokvag2 = userInput.next();
  sokvag2 = userInput.next();

  //Print the result
  System.out.println(sokvag1);
  System.out.println(sokvag2);
  System.out.println(sokvag3);

  userInput.close();