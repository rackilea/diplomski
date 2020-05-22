@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {

    case R.id.action_refresh:
      Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT).show();
      break;

    case R.id.action_settings:
      Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
      break;
    }

    return true;
}