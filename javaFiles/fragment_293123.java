spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Instead of using getSelected(), use position 
        spinnerValue = position;
        //or
        useValueFrom(yourDataArrayAt[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});