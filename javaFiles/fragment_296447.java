@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        this.finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
}