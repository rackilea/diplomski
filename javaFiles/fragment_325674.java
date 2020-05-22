try {
   int maxNumber = 
           Integer.parseInt(JOptionPane.showInputDialog("Please enter input"));

   if (maxNumber > 0) {
     Random rnd = new Random();
     System.out.println(rnd.nextInt(maxNumber));
   } else {
     throw new IllegalArgumentException("Non positive number not allowed");
   }
} catch (NumberFormatException e) {
   throw new IllegalArgumentException("Invalid integer", e);
}