@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.mainmenu, menu);
    MenuItem item = menu.findItem(R.id.menu_item_share);
    mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_item_share) {
        doShare();
    }
    return super.onOptionsItemSelected(item);
}

private void doShare() {

    Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
    shareIntent.setType("text/plain");

    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "I'm Sharing Data");
    shareIntent.putExtra(Intent.EXTRA_TEXT, "Here is my data");

    startActivity(Intent.createChooser(shareIntent, "Share myData to.."));
}