facilities.useDelimiter(",");
while(facilities.hasNextLine()){
    String name = facilities.next();
    String parking = facilities.next(); 
    String bike = facilities.next();
    facilities.nextLine();
    String disability = facilities.next();
    System.out.print("Name: " + name + " ");
    System.out.print("Parking: " + parking + " ");
    System.out.print("Bikes: " + bike + " ");
    System.out.print("disability: " + disability + " ");
    System.out.println();
}