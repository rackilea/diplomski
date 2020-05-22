public void onStopTrackingTouch(SeekBar seekBar) {
          // i want a case statement here switched on the widget ID/name, so 
          // i can set the appropriate string s (bass, treble, volume)
        String s = "set_treble " + progressChanged;
        client.sendMessage(s);

       switch (seekBar.getId()) {
                case R.id.seekVolume:

                    break;
                case R.id.bass:
                    break;
                case R.id.trouble:
                    break;
                default:
                    break;
                }
    }