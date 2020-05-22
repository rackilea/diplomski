FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

fab.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (mSingleton.isNotificationStarted()){
            mSingleton.startNotification(); 
        }
        else {
            mSingleton.stopNotification();
        }

    }
});