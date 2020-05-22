//...
 catch (InputMismatchException e){
      System.out.println("Invalid Input!");
      scanFloat.nextLine(); // will "eat" the wrong entry
      insertPrice(); // try again
 }