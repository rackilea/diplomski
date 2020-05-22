@Override
public void onItemSelected(AdapterView<?> parent, View view, int position,
    long id) {

   String myStr = spinner.getSelectedItem().toString();
   selectedSpinner.setText(myStr);

}

@Override
public void onNothingSelected(AdapterView<?> arg0) {        
}