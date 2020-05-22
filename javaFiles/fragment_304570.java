public static void endOfTheSong() {
        if (isRepeat == 1) { // currently repeat one song
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        } else if (isRepeat == 2) { // currently repeat all songs
            nextSong();
        } else { // currently no repeat

            if (currentPosition != songList.size() - 1) nextSong();

        }
    }