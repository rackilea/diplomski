@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_settings:
            Intent intent = new Intent(this,MyNewActivity.class);
            startActivity(intent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }