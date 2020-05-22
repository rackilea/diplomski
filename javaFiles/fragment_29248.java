@Override 
public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
    if (compoundButton == toggle1) {
        if (isChecked) {
            toggle1Status = true;
        } else { 
            toggle1Status = false;
        } 
    } else if (compoundButton == toggle2) {
        if (isChecked) {
            toggle2Status = true;
        } else { 
            toggle2Status = false;
        } 
    } 
 displayDecimalAnswer();
} 

    /** 
     * Displays decimal answer. 
     */ 
    public void displayDecimalAnswer() {
       int valueOfOnes = (toggle1Status) ? 1 : 0;//Since toggle1Status is class level variable it will be accessibible
       int valueOfTwos = (toggle2Status) ? 2 : 0;
       int answer = valueOfOnes + valueOfTwos;

        TextView decimalView = (TextView) findViewById(R.id.decimal);
        decimalView.setText(""+answer);
    }