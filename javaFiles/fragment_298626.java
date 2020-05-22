public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.settings:     
            Intent intent = new Intent(this, ShowSettings.class);
              startActivity(intent);
        break;
        case R.id.services:     
            Intent intent2 = new Intent(this, Test.class);
            startActivity(intent2);
          break;
        case R.id.Quit: