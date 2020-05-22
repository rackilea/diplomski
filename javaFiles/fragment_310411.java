public void runGUI(){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            GUIControls guiControls = new GUIControls();
            guiControls.pack();
            guiControls.setLocationRelativeTo(null);
            guiControls.setVisible(true);
        }
    });
}