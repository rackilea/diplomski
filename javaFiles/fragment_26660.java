private boolean isChecked = false;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
         MenuItem checkable = menu.findItem(R.id.menu_switch_full_original);
         checkable.setChecked(isChecked);
         return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.a, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
        case R.id.menu_switch_full_original:
            isChecked = !item.isChecked();
            item.setChecked(isChecked);
            // your other functionality
            break;

        default:
            break;
        }
        return super.onOptionsItemSelected(item);
    }