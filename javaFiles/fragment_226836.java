myCheckbox1.setOnCheckChangedListener(new OnCheckChangedListener() {
  @Override
  public void onCheckChanged(CompoundButton buttonView, boolean isChecked) {
    if (isChecked) {
      myCheckbox2.setChecked(false);
      myCheckbox3.setChecked(false);
      myCheckbox4.setChecked(false);

      // start playback
    } else {
      // stop playback
    }
  } 
);