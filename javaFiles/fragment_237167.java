Car myCar = new Car();
myCar.make = "Honda";
myCar.model = "Accord";
myCar.color = "Black";

myCar.goOffroad();
System.out.println(myCar.condition); // dirty
myCar.washMe();
System.out.println(myCar.condition); // clean