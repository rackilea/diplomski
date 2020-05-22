ArrayList<Bicycle> output = new ArrayList<>();
 boolean isFound = false;

 for(Bicycle bicycle : bicycles){
     if (bicycle.getHireNumber() == hireNumber) {
          isFound = true;
          bicycle.setAge(newAge);
          return;//match found, so break & return
     }
  }

 //now check isFound is true, if not print it (only once)
 if(!isFound) {
    System.out.println("No matching bicycle found.");
 }