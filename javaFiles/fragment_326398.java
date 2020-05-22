while(console.hasNext()){
  if(console.hasNextInt()){
   try {
        menuChoice = console.nextInt();
    } catch(InputMismatchException e) {
        System.out.println("The selection you made is invalid.");
    }
  }else{
     //throw away non-ints
       console.next();
  }

}