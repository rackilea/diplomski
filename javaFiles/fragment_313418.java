checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked && numberOfCheckboxesChecked >= 2) {
            checkbox1.setChecked(false);
        } else {
            // the checkbox either got unchecked
            // or there are less than 2 other checkboxes checked
            // change your counter accordingly
            if (isChecked) {
                numberOfCheckboxesChecked++;
            } else {
                numberOfCheckboxesChecked--;
            }

            // now everything is fine and you can do whatever
            // checking the checkbox should do here
        }
    }
});