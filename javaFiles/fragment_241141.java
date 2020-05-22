lstServers.setOnItemClickListener(new OnItemClickListener()
    {
        public  void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Beacon.activeServer = position;
            Intent uploadIntent = new Intent(your_current_activty.this,ImageShareActivity.class);
            uploadIntent.startActivity();
        }
    });