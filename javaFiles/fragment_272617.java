@Override
    public void onCreate() {
        super.onCreate();

        songPosn = 0  // defined as a public integer
        //other stuff
        topText = getResources().getStringArray(R.array.topText_array);
        intent = new Intent(BROADCAST_ACTION);
    }