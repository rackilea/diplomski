protected boolean onTabItemSelected(MenuItem item) {
    if (item.getItemId() != R.id.dog_tab) {
        startActivity(new Intent(this, DogActivity.class));
        return true;
    }
    return false;
}