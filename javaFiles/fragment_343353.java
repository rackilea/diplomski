String newConcatNumString = "";
    Random random = new Random();
    for(int i=0; i < 3; i++){
       newConcatNumString  = newConcatNumString +random.nextInt(10);
    }
    System.out.println(newConcatNumString);