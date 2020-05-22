public static boolean isValidNumber(String uInput) {

  Long convert = Long.parselong (uInput); 
  int convert2 = (int) convert;// Need to do this because of the JOptionPane
  if(colmn.length > convert) {
  System.out.println("The Column exists.");
   return true;
   } 
    else { System.out.println("The Column doesn't exists."); return false;}

 }