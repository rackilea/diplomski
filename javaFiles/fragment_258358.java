@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case R.id.settings:{
     Intent i = new Intent(Home.this, Settings.class);
     startActivity(i);
  }
    }
}