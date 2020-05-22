public void onClick(View v) {
        Log.d("onClick", "On Click worked");
        if (v.getId == R.id.PlayPauseButton) {
            startPlaying();
        }
    }