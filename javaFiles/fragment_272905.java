public static void main(String[] args) {
    try {    
        UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
    } 
    // Probably want to break this into handling the various exceptions that can be thrown.
    catch (Exception e) {
       // handle exception
    }

    // Create Swing GUI and so forth
}