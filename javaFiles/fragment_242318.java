@Override
  public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
    int countOfCheckBoxesChecked = 0;
    for (CheckBox checkbox : allCheckBoxes) {
      if (checkbox.isChecked()) {
        countOfCheckBoxesChecked++;
      }
    }
    Log.i(TAG, "number of checked = " + countOfCheckBoxesChecked);

  }