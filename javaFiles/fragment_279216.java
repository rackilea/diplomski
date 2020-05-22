@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            onBackPressed();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}

@Override
public void onBackPressed() {
    super.onBackPressed();
    // your code here
}