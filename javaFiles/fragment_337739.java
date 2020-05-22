public void actionPerformed(java.awt.event.ActionEvent evt) {
    scanner.close(); //Don't forget to close your scanner before you reassign it
    String data = jTextField1.getText();        
    scanner = new Scanner(data);
    //Just to illustrate the results I added a println here
    System.out.println(scanner.nextLine());               
}