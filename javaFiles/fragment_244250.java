d1.addWindowListener(new WindowAdapter(){
    @Override
    public void windowClosing(WindowEvent arg0) {
        d2.setVisible(false);
    };
});