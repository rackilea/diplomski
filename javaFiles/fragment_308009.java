@Override
public void onItemSelected(AdapterView<?> parent, View view, int position,
        long id) {
    // On selecting a spinner item

  resumeTableName = parent.getItemAtPosition(position).toString();



 // Showing selected spinner item
    Toast.makeText(parent.getContext(),  resumeTableName,
            Toast.LENGTH_LONG).show();


}