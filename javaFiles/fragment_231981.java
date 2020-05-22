public int onStartCommand(Intent intent, int flags, int startId) {
    String activeAudio = intent.getStringExtra("activeAudioUrl");
    MethodChannel methodChannel = intent.getParcelableExtra("channelInstance");
    Bundle b = intent.getExtra();
    DataToSend data = (DataToSend) b.getParcelable("data");

    // Here you can retrieve your data(channel & activeAudio) from following
    // data object. (e.g. data.getAudio())
    ...
}