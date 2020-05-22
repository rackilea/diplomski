public handleCheckBoxSelection(boolean isSelected){
    if (numberOfCheckedBoxes  == 4){
        JOptionMessage.showMessageDialog("Can not select more than 4 check boxes");
        return;
    }
    if (isSelected){
        increaseNumberOfCheckedBoxes();
    }else{
        reduceNumberOfCheckedBoxes();
    }
}