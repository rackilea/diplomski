public void onCreate() {
 ....
Country[] mCountries = ... ;
final Spinner spinner1 = ...;
final Spinner spinner2 = ...;

spinner1.setAdapter(new ArrayAdapter(mCountries);
spinner1.setOnItemSelectedListener( new OnItemSelectedListener() {

void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    Country country = (Country) parent.getAdapter().getItem(position);
    spinner2.setAdapter(new ArrayAdapter(country.getStates());
 }
 void onNothingSelected(AdapterView<?> parent) {
    spinner2.setAdapter(null);
 }
});