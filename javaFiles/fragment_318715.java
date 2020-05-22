int delay = 1000; //milliseconds
ActionListener taskPerformer = new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        showStatus(MineButton.flagCount + "");   // need to make sure that you can call showStatus
    }
};

new javax.swing.Timer(delay, taskPerformer).start();