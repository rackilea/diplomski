for (Directory entry : nameList) {
    System.out.println("Name: " + entry.GetID());
    System.out.println( "Age:\t");
    double age = LocalInput.nextDouble();
    entry.setAge(age);
    System.out.print( "Address:\t");   
    String address = LocalInput.nextLine();
    entry.setAddress(address);
}