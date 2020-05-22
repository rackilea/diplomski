JButton closeButton = new JButton("Close");

closeButton .addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        this.dispose();//current(close only this) frame
        new frameName().setvisible(true);
    }
});