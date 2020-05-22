public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            NewJFrame newJFrame = new NewJFrame();
            newJFrame.pack();
            // no need to set visible false. It already is

            MyDialog myDialog = new MyDialog(newJFrame); 
            // make sure the super constructor makes the dialog modal

            myDialog.pack();
            myDialog.setVisible(true);

            // here the dialog is no longer visible
            // and we can extract data from it and send it to the JFrame if needed

            newJFrame.setVisible(true); // ****** here
        }
    });
}