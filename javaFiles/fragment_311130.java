holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Store songList and songIndex in mSharedPreferences
        storageUtil.storeSong(Main.musicList);
        storageUtil.storeSongIndex(holder.getAdapterPosition());

        // Obtain context from view instance.
        Context context = v.getContext();

        //Send media with BroadcastReceiver
        Intent broadCastReceiverIntent = new Intent(Constants.ACTIONS.BROADCAST_PlAY_NEW_SONG);
        context.sendBroadcast(broadCastReceiverIntent);

        Intent broadCastReceiverIntentUpdateSong = new Intent(Constants.ACTIONS.BROADCAST_UPDATE_SONG);
        context.sendBroadcast(broadCastReceiverIntentUpdateSong);
    }
});