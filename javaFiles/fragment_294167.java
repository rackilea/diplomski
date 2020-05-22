@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId(); //you must use item id not group id
    if(id == R.id.contactSettings) {
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
    }
    return true;
}