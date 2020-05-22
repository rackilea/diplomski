if(input.matches("[A-Z][0-9]{4}")) { 
   String newRegistration = input;
   System.out.print("Enter the owner's name");
   String newOwner = scanner.nextLine();
   Car car = new Car(newRegistrationNumber, newOwner);

  ArrayList<ParkingSlot> parkingSlot = carPark.getParkingSlot();
  Iterator<ParkingSlot> iterator = parkingSlot.iterator;
  ParkingSlot ps = iterator.next();
  while(iterator.hasNext()) {
     if(!ps.isOccupied()) {
         ps.parkCar(car);
     }
  }
}