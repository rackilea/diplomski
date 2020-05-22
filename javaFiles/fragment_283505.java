SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run(){
        Message.createAndShowDialog("Content", 5000); // wait 5 seconds before disposing dialog
    }
});