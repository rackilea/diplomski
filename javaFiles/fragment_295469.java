public void disableRG() {
    for(int i = 0; i < radioGroup.getChildCount(); i++){
        ((RadioButton)radioGroup.getChildAt(i)).setEnabled(false);
    }
}

 public void enableRG() {
        for(int i = 0; i < radioGroup.getChildCount(); i++){
            ((RadioButton)radioGroup.getChildAt(i)).setEnabled(true);
        }
    }