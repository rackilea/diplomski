private void playSong(String path) throws IllegalArgumentException,
            IllegalStateException, IOException {

        setContentView(R.layout.activity_android_building_music_player);
        Log.d("ringtone", "playSong :: " + path);

        mMediaPlayer.reset();
        mMediaPlayer.setDataSource(path);
//mMediaPlayer.setLooping(true);
        mMediaPlayer.prepare();
        mMediaPlayer.start();
        acv(path);
    }

    public void acv(String path) {
        getInit();

        metaRetriver = new MediaMetadataRetriever();
        metaRetriver.setDataSource(path);
        try {
            art = metaRetriver.getEmbeddedPicture();
            Bitmap songImage = BitmapFactory.decodeByteArray(art, 0, art.length);
            album_art.setImageBitmap(songImage);
        } catch (Exception e) {
            album_art.setBackgroundColor(Color.GRAY);

        }

    }