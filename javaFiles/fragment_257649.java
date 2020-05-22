public static void main(String[] args) {

    String responded;
       do{
         responded = JOptionPane.showInputDialog("Do you understand do while loops?");
         boolean legitimate = false;
         do {
             String number = JOptionPane.showInputDialog("Choose a number between 0 & 9 to generate \nthe corresponding word to that number or \npress 10 to exit the program");
             switch(number) {
             case "0" :
             case "1" :
             case "2" :
             case "3" :
             case "4" :
             case "5" :
             case "6" :
             case "7" :
             case "8" :
             case "9" : legitimate = true;
                        break;
             default:
                 JOptionPane.showMessageDialog(null, "Please make sure the number inserted is between 0 & 10.", "Error", JOptionPane.ERROR_MESSAGE);
                 break;
             }
     } while(!legitimate);
} while (responded.equalsIgnoreCase("No"));