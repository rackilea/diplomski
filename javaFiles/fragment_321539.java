public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    //here fetch the data from shared prfrencess which done on oncrete
    //use if else here
    menu.findItem(R.id.two_week).setChecked(checked);
    return true;
}