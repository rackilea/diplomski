// find RadioButton
RadioGroup rGroup = findViewById(R.id.radioGroup1);
RadioButton checkedRadioButton = rGroup.findViewById(rGroup.getCheckedRadioButtonId());

// define selected option value
int selectedOption = 0;
for (int i = 0; i < buttons.size(); i++) {
  if (checkedRadioButton.getId() == buttons.get(i).getId()) {
    selectedOption = i;
    break;
  }
}

// write state to SP
getSharedPreferences("my_settings", Context.MODE_PRIVATE).edit().putInt("sel_option", selectedOption).apply()