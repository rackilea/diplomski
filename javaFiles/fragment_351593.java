ArrayList<Car> carList = new ArrayList<Car>();
    carList.add(car1);

    //Call the get(index) method to get the car object and then call the class method you want.
    carList.get(0).getMake();
    carList.get(0).getModel();

    //A class always should have a toString() method that returns the string with all the values of class instance.
    System.out.println(carList.get(0).toString());