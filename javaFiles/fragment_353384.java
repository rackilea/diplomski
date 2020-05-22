spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        selectedSong = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {}
});