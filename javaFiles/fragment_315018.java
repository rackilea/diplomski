String[] chooseFlavors = {"plain", "strawberry", "raspberry", "caramel", "chocolate"};
... 

boolean flavorFound = false;
while (!flavorFound) { // Loop until flavorFound is true
  System.out.println("Please choose flavor:");                                            
  userFlavor = scnr.nextLine();

  for(int i = 0; i < chooseFlavors.length; i++) { // Loop from 0 to choosFlavors.length
      if(userFlavor.equals(chooseFlavors[i]) { // Compare user input to flavor at index i
          System.out.println(userFlavor + " found at index " + i);
          flavorFound = true; // This is the flag to break out of while loop
          break; // Only breaks out of for loop
      } else {
          System.out.println("Please choose from flavors above.");
      }
  }

}