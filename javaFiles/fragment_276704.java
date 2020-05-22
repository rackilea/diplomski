String[] details = newLine.split(" ");
     if(details.length != 3) {
       System.out.println("Incorrect data entered !! Please try again !!! ");
      return;
      } else {
       String brand = details[0];
       String model = details[1];
       double cost = Double.parseDouble(details[2]);
       Car c = new Car(brand, model, cost);
       Car.add(c);
     }