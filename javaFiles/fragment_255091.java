if(petType.equals("DOG")) {

  try {
    String name = input.next();
    String owner = input.next();
    double weight = input.nextDouble();
    SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
    Date vaccineDate = stdDate.parse(input.next());
    boolean fixed = input.nextBoolean();
    Dog x = new Dog(name,owner,weight,vaccineDate,fixed);
    object.addPet(x);
  }
  catch(NoSuchElementException ex) {
    System.out.println("ERROR - Missing fields. Skipping line " + lineNumber + "...");
    input.nextLine();
  }
  catch (ParseException ex) {
    System.out.println("ERROR - Vaccine date " + input.next() + " is not in mm/dd/yy format!");
    input.nextLine();
  }
}