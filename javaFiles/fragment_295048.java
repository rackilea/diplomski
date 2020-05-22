class Artist {
    public final String name;
    public final ArrayList<Song> songs = new ArrayList<>();

    Artist(String name) {
        this.name = name;
    }

    void addSong(Song song) {
        this.songs.add(song);
    }
}