public void parkCar(Car car) {
    for (int i = 0; i < cars.length; i++) {
        if (cars[i] == null) {
            cars[i] = car;
            return; // do not allocate other null spaces with same car, leave space for the next cars
        }
    }

   System.out.println("Sorry, no space left for parking");
  //here you can add code so as to see a parking space at some other place , may be you can have a 2-d array with each row representing a parking space. 
}