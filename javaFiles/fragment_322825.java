Scanner scanner = new Scanner(System.in);

  int choice = 0;

  while (scanner.hasNext()) {
     if(scanner.hasNextInt()) {
         choice = scanner.nextInt();
         break;
     }

     System.out.println("Incorrect input, try again");
     scanner.next();
  }

  scanner.close();

  // switch statement etc
  switch(choice) {
      //...
  }