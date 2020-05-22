Frame f2 = new Frame();
    f2.setVisible(true);
    f2.setLayout(null);
    f2.setSize(500,500);
    f2.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent w)
        {
        f2.dispose();
        }       
    });