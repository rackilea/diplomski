final ProgressWindow pr = new ProgressWindow(null, null);
Timer timer=new Timer(2000,new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
       pr.dispose(); 
    }
});
timer.setRepeats(false);
timer.start();