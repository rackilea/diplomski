@Override public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

    switch(parentView.getId()){
        case R.id.weightFSpinner:
            fValue= weightFSpinner.getSelectedItem().toString();
            break;
        case R.id.weightSSpinner:
            sValue= weightSSpinner.getSelectedItem().toString();
            break;
        case ...
    }


}