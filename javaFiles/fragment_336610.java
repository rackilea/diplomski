Vector carList = new Vector();
for(int i = 0; i<cars.length; i++){
    if(cars[i].doors > 4)
         carList.addElement(cars[i]);
    }
}
Car[] carArray = new Car[carList.size()];
carList.copyInto(carArray);