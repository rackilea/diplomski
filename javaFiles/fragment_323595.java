private void addSongs(int index, long maxLength){

        if (TimeUnit.MILLISECONDS.toSeconds(currentLength) <= maxLength){
            int i;
            for (i = 0; i < songList.size() && TimeUnit.MILLISECONDS.toSeconds(currentLength) != maxLength; i++){
                    timerSongs.add(songList.get(i));
                    currentLength = currentLength + songList.get(i).getDuration();
                    addSongs(i, maxLength);
            }
            if (i >= songList.size()){
                currentLength = currentLength - timerSongs.get(timerSongs.size()-1).getDuration();
                timerSongs.remove(timerSongs.size()-1);
            }
        } else {
            currentLength = currentLength - timerSongs.get(timerSongs.size()-1).getDuration();
            timerSongs.remove(timerSongs.size()-1);
        }

}