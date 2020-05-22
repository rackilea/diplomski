holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
  @Override
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    isChecked[position] = isChecked;
  }
});

holder.checkBox.setChecked(isChecked[position]);