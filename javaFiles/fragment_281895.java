@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        // ... Stuff ...
    case R.id.settings: // Settings item
        Intent i = new Intent(this, About.class); // Start About.java Activity, but item says "settings"
        // TODO: Change About to Settings?
        i = new Intent(this, Settings.class);
        startActivity(i);
        return true;

    case R.id.about: // About item
        Intent about = new Intent(this, About.class); // Start About.java Activty
        startActivity(about);
        return true;

    default:
        return super.onOptionsItemSelected(item);
    }
}