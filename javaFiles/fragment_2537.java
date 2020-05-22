enum MusiqueComparator implements Comparator<Musique> {
  ARTISTE {
    @Override public int compare(Musique a, Musique b) {
      return b.getArtiste().compareTo(a.getArtiste());
    }
  },
  ALBUM {
    @Override public int compare(Musique a, Musique b) {
      return b.getAlbum().compareTo(a.getAlbum());
    }
  },
  TITRE {
    @Override public int compare(Musique a, Musique b) {
      return b.getTitre().compareTo(a.getTitre());
    }
  }
}