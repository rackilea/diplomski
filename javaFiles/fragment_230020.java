public static void main(String args[]) {
/* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                new SPPMainGUI().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SPPMainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
}