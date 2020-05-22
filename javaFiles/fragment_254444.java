@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            onBackPressed(); // or finish();
            return true;
    }
    return super.onOptionsItemSelected(item);
}