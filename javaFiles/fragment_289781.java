String beforeTitle = driver.getTitle();

  //put your Click Submit Button code here

  String afterTitle = driver.getTitle();

  if(beforeTitle.equals(afterTitle)){

    System.out.println("Bad Login Information!!");

   }