public static void main(String[] args)
        throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {

        final JFrame myFrame = new JFrame("Main frame");
        final JLabel jLabel = new JLabel("Please wait...");
        final JDialog d = new JDialog(myFrame, "I'm waiting");

        @Override
        public void run() {
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setSize(750, 500);
            myFrame.setLocationRelativeTo(null);
            myFrame.setVisible(true);

            d.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

            d.add(jLabel);
            d.setSize(300, 200);
            d.setLocationRelativeTo(null);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(3000); // simulate process
                        System.out.println("After");
                        SwingUtilities.invokeLater(new Runnable() {

                            public void run() {


                                d.setVisible(false);
                                d.dispose();

                                myFrame.setVisible(false);
                                myFrame.dispose();
                            }
                        });
                    } catch (InterruptedException ex) {
                    }
                }
            }).start();
            d.setVisible(true);

        }
    });
}