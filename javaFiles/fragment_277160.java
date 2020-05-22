button.addActionListener(new ActionPerformed(ActionEvent e){
    @Override
    public void actionPerformed(ActionEvent e) {
        new LogViews(MainFrame.this, true);
    }
}