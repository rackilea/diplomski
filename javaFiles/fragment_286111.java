@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show(); 
        break;
    }
    return true;
}