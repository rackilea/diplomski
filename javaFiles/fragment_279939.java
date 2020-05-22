private void addChip(String pItem, ChipGroup pChipGroup) {
    Chip lChip = new Chip(this);
    lChip.setText(pItem);
    lChip.setTextColor(getResources().getColor(R.color.primary_text));
    lChip.setChipBackgroundColor(getResources().getColorStateList(R.color.chip_bg));

    pChipGroup.addView(lChip, pChipGroup.getChildCount() - 1);
  }