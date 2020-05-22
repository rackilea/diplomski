Map<String, Car> cars = new HashMap<> ();                   
cars.put ("ID1", new Car("Dave", "LT12 DDS"));             
cars.put ("ID2", new Car("Steve", "GB14 HHG"));
cars.put ("ID3", new Car("Molly", "LT18 SDF"));

Scanner ab=new Scanner(System.in);  

System.out.println("Enter ID: ");  
String inputedID = ab.nextLine();

System.out.println("Car with " + inputedId + " is " + cars.get(inputedId));