@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    Toast.makeText(getApplicationContext(), "Selected Item : " 
                   + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
}