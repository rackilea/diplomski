@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this, "Search Button Pressed !", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_compose:
                // do something when the user press the button Compose.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }