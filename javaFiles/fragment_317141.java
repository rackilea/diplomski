new javax.swing.Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        long usPosition = theClip.getMicrosecondPosition();
        // put it somewhere
    }
}).start();