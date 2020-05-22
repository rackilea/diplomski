public static void main(String[] args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {

            // build and show your GUI               

            Component1 sp = new Component1 ();
            sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sp.setVisible(true);
        }
    });
}