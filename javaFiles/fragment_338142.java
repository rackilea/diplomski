private void manageBoxes(){
    int count = 0;
    for(CheckBox box : boxes){
        count += box.isChecked()?1:0;
    }

    if(count>=2){
        for(CheckBox box : boxes){
            box.setEnabled(box.isChecked());
            box.setClickable(box.isChecked()); // not sure if needed
        }
    }else{
        // reset all boxes
        for(CheckBox box : boxes){
            box.setEnabled(true);
            box.setClickable(true);
        }
    }
}