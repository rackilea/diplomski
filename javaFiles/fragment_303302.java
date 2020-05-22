public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {

        // This code will start the new activity when the settings button is clicked on the bar at the top.
        Intent intent = new Intent(Quoter.this, newActivityName.class);
        startActivity(intent)
        return true;
    }

    return super.onOptionsItemSelected(item);
}