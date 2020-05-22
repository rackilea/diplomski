final Timer tm = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("10 SECONDS AND NOTHING HAPPENED");
    }
});
tm.start();
Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {    
    @Override
    public void eventDispatched(AWTEvent event) {
        tm.restart();
    }
}, -1);