public class Pangea {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                   createAndShowGUI();
                }
            });

        }

     /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        System.out.println("Initializing GUI.");
        JFrame frame = new JFrame();
        frame.setTitle("PANGEA RPG [0.01 ALPHA][WIP]");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new UI().getPanel());


        frame.pack();//sizes the frame
        frame.setVisible(true);
        System.out.println("GUI Initialized.");
    }
}