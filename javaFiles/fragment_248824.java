@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main1, menu);// Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
        case R.id.action_maintain:
            Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
            return true;

        default:
            return super.onOptionsItemSelected(item);
        }
    }