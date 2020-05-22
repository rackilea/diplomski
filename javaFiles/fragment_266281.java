private BroadcastReceiver NewSongBroadCastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        songList = new StorageUtil(getApplicationContext()).getSongs();
        songIndex = new StorageUtil(getApplicationContext()).loadSongIndex();
        if (songIndex != -1 && songIndex < songList.size()){
            activeSong = songList.get(songIndex);
        }else{
            stopSelf();
        }
        stopSong();
        mediaPlayer.reset();
        initMediaPlayer();
        updateMetaData();
        NotificationBuilder(PlaybackStatus.PLAYING);
    }
};