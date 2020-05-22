public void buildSongSet(String word, Song firstSongWithWord) {     
    TreeSet<Song> songSet= new TreeSet<Song>();
    songSet.add(firstSongWithWord);
    lyricWords.put(word, songSet);
    System.out.println("Word added "+word);
}