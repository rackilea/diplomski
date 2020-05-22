@Override
public void onItemSelected(AdapterView<?> parent, View v, int position,
    long id) {
    switch(v.getId) {
    case R.id.mySpinner1:
        // Do stuff when the mySpinner1 has been selected like changing some text on a button like so:
        someString = "myNewString";
        myButton1.setText(someString);
        break;
    case R.id.mySpinner2:
        // Do stuff when the mySpinner2 has been selected like changing some text on another button like so:
        someOtherString = "mybrandNewString";
        myButton2.setText(someOtherString);
        break;
    default:
        break;
    }
}