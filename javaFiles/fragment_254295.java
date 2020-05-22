public Test() {
        initGUI();
        button.addActionListener((ActionEvent e) -> {
            JFrame frame1 = new JFrame("Second Jframe");
            frame1.setPreferredSize(new Dimension(300, 300));
            frame1.getContentPane().add(new JLabel("Swing Component"));
            frame1.pack();
            frame1.setVisible(true);
            frame1.setLocationRelativeTo(null);

            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        Thread.sleep(7000);
                        System.out.println("statement 1");
                        Thread.sleep(7000);
                        System.out.println("statement 2");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return null;
                }
            }.execute();
        });

}