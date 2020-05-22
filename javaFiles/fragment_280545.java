public void ShowText() {
    int inOne = sbSyst.getProgress() + 70;
    int inTwo = sbDias.getProgress() + 40;

    if((inOne >= 140) || (inTwo >= 90)) {
        // condition 1: if 140 or more systolic or 90 or more diastolic means HIGH BP
        tvRes.setText("HIGH");
        tvRes.setBackgroundColor(Color.parseColor("#F70729"));
    }
    else if((inOne <= 90) || (inTwo <= 60)){
        // (condition 1 is not met)
        // condition 2: if 90 or less systolic or 60 or less diastolic means LOW BP
        tvRes.setText("LOW");
        tvRes.setBackgroundColor(Color.parseColor("#7659F5"));
    }
    else if((inOne >= 120) || (inTwo >= 80)) {
        // (condition 1 and 2 are not met ==> NOT HIGH, NOT LOW)
        // condition 3: if 120 or more systolic or 80 or more diastolic means PRE-HIGH BP
        tvRes.setText("PRE-HIGH");
        tvRes.setBackgroundColor(Color.parseColor("#D7EF0C"));
    }
    else if((inOne >= 90) || (inTwo >= 60)) {
        // (condition 1, 2 and 3  are not met ==> NOT HIGH, NOT LOW, NOT PRE-HIGH)
        // condition 4: if 90 or more systolic or 60 or more diastolic means IDEAL BP
        tvRes.setText("IDEAL");
        tvRes.setBackgroundColor(Color.parseColor("#0BA319"));
    }
}