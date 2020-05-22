double depValue;
while(true){
     System.out.print("Amount to deposit: ");                   
     depIn = depositInput.readLine();
     try {
          if ((depValue = Double.parseDouble(depIn)) > 0)
              break;
          System.out.println("The number needs to be positive!");
     } catch(NumberFormatException ne) {
          System.out.println("You did not enter a number!");
     }
}