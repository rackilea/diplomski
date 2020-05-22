btnCheckUpdates.setOnClickListener(new OnClickListener()
    {
        @Override
        public void onClick(View arg0)
        { 
           new YourTask().execute();
        }
    });