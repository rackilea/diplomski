public static void nextSong() {
        int numOfSong = songList.size();

        if (!isShuffle) { // Shuffle mode is off
            if (currentPosition < numOfSong - 1) {
                currentPosition++;
                currentSong = songList.get(currentPosition);
                Log.d("my_log", "position = "+currentPosition);
                playBackMusic();
            } else {
                currentPosition = 0;
                currentSong = songList.get(currentPosition);
                Log.d("my_log", "position = "+currentPosition);
                playBackMusic();
            }
        } else { // Shuffle mode is on
            Random rand = new Random();
            currentPosition = rand.nextInt(numOfSong);
            currentSong = songList.get(currentPosition);
            Log.d("my_log", "position = "+currentPosition);
            playBackMusic();
        }
    }