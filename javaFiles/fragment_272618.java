@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         //other stuff
         broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    updateUI(intent);
                }
            };
    }

    private void updateUI(Intent intent){
        String nowPlaying = intent.getStringExtra("nowPlaying");
        songNowPlayingLabel.setText("Now Playing : " + nowPlaying);
    }