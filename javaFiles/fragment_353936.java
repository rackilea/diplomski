@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser) {
              mediaPlayer.seekTo(progress);
            }
        }