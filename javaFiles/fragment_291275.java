while(condition){
    String twoStr = null;

    try {
        twoStr= JOptionPane.showInputDialog("Enter two words sep by a space.");
     } catch (IOException e) {
        System.out.println("Sorry your words are terrible.");
     }

     //do stuff with twoStr