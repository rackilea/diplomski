public static void main(String[] args) {
try {
        // Set L&F 
    UIManager.setLookAndFeel(
        new TinyLookAndFeel());
} catch (Exception e) {
   // handle exception
   e.printStackTrace(); 
}

new SwingApplication(); //Create and show the GUI.