final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    JLabel label = new JLabel("Please wait...");
    label.setFont(new Font("Serif", Font.PLAIN, 25));
    frame.getContentPane().add(label, BorderLayout.CENTER);
    frame.setLocationRelativeTo(null);
    frame.setUndecorated(true);
    frame.pack();
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);

    new Thread(new Runnable() {
        @Override
        public void run() {
        try{            
            longTime();  //HERE IS THE FUNCTION THAT TAKES A LONG TIME  
        }catch(Exception e){   }
            frame.dispose();     //AFTER THE LONG FUNCTION FINISHES, DISPOSE JFRAME     
        } 
        }).start();