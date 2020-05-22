ChipGroup filterChipGroup = findViewById(R.id.filter_chip_group);
    Chip filterChip = findViewById(R.id.filter_chip);
    Chip filterChip2 = findViewById(R.id.filter_chip2);
    CompoundButton.OnCheckedChangeListener filterChipListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Log.i(TAG, buttonView.getId() + "");
        }
    };
    filterChip.setOnCheckedChangeListener(filterChipListener);
    filterChip2.setOnCheckedChangeListener(filterChipListener);