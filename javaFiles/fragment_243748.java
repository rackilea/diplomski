redCB = new JCheckBox("Red");
redCB.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        handleCheckBoxSelection(redCB.isSelected());
    }
});