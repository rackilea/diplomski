dayShift_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked && nightShift_check.isChecked()) {
            dayShift_check.setChecked(false);
            nightShift_check.setChecked(false);
        }
    }
});