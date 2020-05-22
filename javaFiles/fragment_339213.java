checkDistance.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        if (!checkDistance.isChecked()) {
            flag = false;//the flag to recycle view
        }
        if (checkDistance.isChecked()) {
            flag = true;//the flag to recycle view
        }
    }
});