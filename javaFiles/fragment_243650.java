//Create a boolean
    boolean found= false; 
    for(int i=0; i<arr.size(); i++) {
        //If entered ID matches, print laptop information.
        if(inputId == ((Laptops) arr.get(i)).getId()) {
            System.out.println(((Laptops)arr.get(i)).getModel() + " CPU: " + ((Laptops)arr.get(i)).getCpu() + " GPU: " +
                    ((Laptops)arr.get(i)).getGpu() + " Memory: " + ((Laptops)arr.get(i)).getMemory() + "GB ID: " + 
                    ((Laptops)arr.get(i)).getId());
                    //set boolean true and break
                    found = true;
                    break;
        }
    }
  //Out side the look check If entered ID does not match, print invalid ID.
    if(!found) {
       System.out.println("Invalid ID.");
    }