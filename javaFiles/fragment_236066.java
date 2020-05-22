EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            JFrame frame = new JFrame();                
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            frame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent we) {
                    System.out.println("closing...");
                }

                @Override
                public void windowClosed(WindowEvent we) {
                    System.out.println("closed..");
                }
            });

            frame.setVisible(true);
        }
 }