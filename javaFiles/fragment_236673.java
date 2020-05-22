JButton toParent = new JButton("/..");
toParent.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent a) {
        fc.changeToParentDirectory();
    }
});
fc.add(toParent, BorderLayout.NORTH);