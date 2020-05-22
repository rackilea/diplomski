class Album {
  Artist artist;

  Album(Artist artist) {
    this.artist = artist;
  }

  void playLive() {
    artist.performance();
  }
}