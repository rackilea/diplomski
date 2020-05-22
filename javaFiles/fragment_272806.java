@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {

        case 222:
            if (requestCode == 222) {

                if (resultCode == RESULT_OK) {

                    //the selected audio.
                    Uri uri = data.getData();

                    MediaPlayer mediaPlayer = MediaPlayer.create(this, uri);
                    mediaPlayer.setLooping(false);

                    mediaPlayer.setOnPreparedListener(mp -> mp.start());
                    mediaPlayer.setOnCompletionListener(mp -> finish());

                }
            }
            break;
        default:
            super.onActivityResult(requestCode, resultCode, data);
            break;
    }
}