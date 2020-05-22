public static void main(String[] args) {
    util = new Updater(); // <-- don't do this, it calls Swing code from a thread that is not EDT
    // Schedule a job for the event dispatch thread.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {

            // setup a new GUI
            util.createGUI(); // <-- creates an instance of SelfUpdater and adds it to GUI
            JFrame rFrame = util.getRootFrame();                
            JPanel gFrame = util.getCardLayoutFrame();
            CardLayout cards = (CardLayout) gFrame.getLayout();
            cards.show(gFrame, "UpdateUpdaterPanel");

            rFrame.pack();
            rFrame.setLocationRelativeTo(null);
            rFrame.setVisible(true);

            SelfUpdater selfUp = new SelfUpdater(); // <-- creates another instance             
            int needUpdate = selfUp.checkForUpdate();                                       
            if (needUpdate == 2) {// Update available for download. Download it.
                selfUp.downloadUpdate();

            } 


        }
    });

}