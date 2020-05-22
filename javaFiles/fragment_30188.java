public YourActivity extends Activity {
...
private String[] mValues = {"One", "Two", "Three"};
private Spinner mSpinner;
public void onCreate(Bundle bundle) {
...
mSpinner = findViewById(R.id.yourspinner);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(
   this, android.R.layout.simple_spinner_item, mValues);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
mSpinner.setAdapter(adapter);
...
}