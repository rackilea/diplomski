if (savedInstanceState == null) {
    Bundle extras = getIntent().getExtras();
    if(extras == null) {
        yourObjectToReceive = null;
    } else {
        yourObjectToReceive = (YourObjectToReceiveClass) extras.getSerializable("KEY");
    }
} else {
    yourObjectToReceive = (YourObjectToReceiveClass)savedInstanceState.getSerializable("KEY");
}