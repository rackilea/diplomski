private void lockScreenControls() {

    // Use the media button APIs (if available) to register ourselves for media button
    // events

    MediaButtonHelper.registerMediaButtonEventReceiverCompat(mAudioManager, mMediaButtonReceiverComponent);
    // Use the remote control APIs (if available) to set the playback state
    if (mRemoteControlClientCompat == null) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        intent.setComponent(mMediaButtonReceiverComponent);
        mRemoteControlClientCompat = new RemoteControlClientCompat(PendingIntent.getBroadcast(this /*context*/,0 /*requestCode, ignored*/, intent /*intent*/, 0 /*flags*/));
        RemoteControlHelper.registerRemoteControlClient(mAudioManager,mRemoteControlClientCompat);
    }
    mRemoteControlClientCompat.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
    mRemoteControlClientCompat.setTransportControlFlags(
            RemoteControlClient.FLAG_KEY_MEDIA_PAUSE |
            RemoteControlClient.FLAG_KEY_MEDIA_PREVIOUS |
            RemoteControlClient.FLAG_KEY_MEDIA_NEXT |
            RemoteControlClient.FLAG_KEY_MEDIA_STOP);

  //update remote controls
    mRemoteControlClientCompat.editMetadata(true)
            .putString(MediaMetadataRetriever.METADATA_KEY_ARTIST, "NombreArtista")
            .putString(MediaMetadataRetriever.METADATA_KEY_ALBUM, "Titulo Album")
            .putString(MediaMetadataRetriever.METADATA_KEY_TITLE, nombreCancion)
            //.putLong(MediaMetadataRetriever.METADATA_KEY_DURATION,playingItem.getDuration())
                    // TODO: fetch real item artwork
            .putBitmap(RemoteControlClientCompat.MetadataEditorCompat.METADATA_KEY_ARTWORK, getAlbumArt())
            .apply();
    }
}