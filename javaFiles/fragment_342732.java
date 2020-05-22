while (errorLoop) {
    if (kb.hasNextInt()) {
        Player.setBet(kb.nextInt()); 
        if (Player.getBet() > 0) { 
            errorLoop = false; 
        } else {
            kb.nextLine();
            System.out.println("Please enter a positive number."); 
        }
    } else {
        kb.nextLine();
        System.out.println("Please enter a positive number."); 
    }            
}