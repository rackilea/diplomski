boolean found = false;
for (Car car : Car.values()) {
  int j = car.getNumber();
  if(CarsLv1.cars[j] != 0) continue;

  for(int i=1;i <= 25;i+=2){
    Part.parts[i] -=1;
  }                                
  CarsLv1.cars[j] +=1;
  JOptionPane.showMessageDialog (null, "You have gained " + car.getName() + "!", "Congratulations", JOptionPane.INFORMATION_MESSAGE, car.getIcon());
  found = true;
  break;
}
if (!found) {
  // Show the message about having collected all cars.
}