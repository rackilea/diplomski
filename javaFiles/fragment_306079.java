finishButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        for (int i = 0; i < 4; i++) {
            radioGroup[i].clearCheck();
            for (int j = 0; j < 4; j++) {
                radioGroup[i].getChildAt(j).setEnabled(true);
                ((RadioButton)radioGroup[i].getChildAt(j)).setTextColor(Color.RED);
                ((RadioButton)radioGroup[i].getChildAt(j)).setChecked(false);
            }
        }
    }
});