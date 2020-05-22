String search2 = JOptionPane.showInputDialog("Enter Indicator Code");

boolean found2 = false; 
Indicator idct3 = (Indicator)bigdata.getFirst();

while (idct3 != null){

     if ( idct3.getICode().equalsIgnoreCase(search2)){
              int search3 = Integer.parseInt(JOptionPane.showInputDialog("Enter year"));
              found2 = true;
              searchYear(idct3,search3); // Indicator passed in here
     }
     if (!found2) {
              System.out.println("Indicator Code is not in the data");       
     }
     idct3 = (Indicator)bigdata.getNext();
}