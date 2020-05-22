String fullName="Steve Emond";
  String[] nameArray=fullName.split(" ");
  if(nameArray.length==1)
  {
   System.out.println("LastName: " + nameArray[0]);
     
  }else if(nameArray.length==2){
   System.out.println("FirstName: " + nameArray[0]);
   System.out.println("LastName: " + nameArray[1]);      
  }
  else if(nameArray.length==3){
   System.out.println("Salutation: " + nameArray[0]);
   System.out.println("FirstName: " + nameArray[1]);
   System.out.println("LastName: " + nameArray[2]);      
  }