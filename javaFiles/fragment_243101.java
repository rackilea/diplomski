slctn = scnr.nextLine();
     if (slctn.equals("a")){
         travel exeTravel = new travel();
         exeTravel.travel();
     }else if (slctn.equals("b")){
         learn exeLearn = new learn();
         exeLearn.learn();
     }else{
         System.out.println("That is not a valid option");
     }