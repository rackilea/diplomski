Scanner stdin1 = new Scanner("file1.txt");
  Scanner stdin2 = new Scanner("file2.txt");

  while(stdin1.hasNext()){
     while(stdin2.hasNext()){
        Object one = stdin1.next();
        Object two = stdin2.next();

        if(one.equals(two)){
           //This line below is giving the error
           System.out.println(one + " " + two );
         }
      }
    }