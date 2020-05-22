MarriedPerson[] mp = new MarriedPerson[3];

 /.../
 Iterator iter = mpList.iterator();
 while(iter.hasNext()){
     MarriedPerson mp = (MarriedPerson)iter.next(); //hey already an array named mp
     mp.printInfo();
 }