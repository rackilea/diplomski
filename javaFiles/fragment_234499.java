new Timer(30 * 1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Assuming wilbur is an instance of Wilbur
        System.out.println("Catches: " + wilbur.getCatchCount()); 
        System.out.println("Misses: " + wilbur.getMissCount());

        System.exit(0);
    }
}).start();