redCB = new JCheckBox("Red");
redCB.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        if (numberOfCheckedBoxes  == 4){
            JOptionMessage.showMessageDialog("Can not select more than 4 check boxes");
            return;
        }
        if (redCB.isSelected()){
            increaseNumberOfCheckedBoxes();
        }else{
            reduceNumberOfCheckedBoxes();
        }
    }
});