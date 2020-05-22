racingCarsCodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // here you have to update 
        TextView selectedView = (TextView) view;
        selectedView.setText(racingCarsArray.get(position).split(" ",2)[0]);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
});