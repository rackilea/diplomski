for (final Album album : albumCollection) {
  final String type = album.getMediaType();
  System.out.print(type + " album: " + album.getTitle()
      + " (" + album.getGenre() + ") - ");
  if (type.equals("CD")) {
    final CDAlbum cd = (CDAlbum) album;
    System.out.println(cd.getArtist());
    int n = 0;
    for (final String track : cd.getTrackList()) {
      System.out.printf("#%2d - %s\n", ++n, track);
    }
  } else {
    final DVDAlbum dvd = (DVDAlbum) album;
    System.out.println(dvd.getDirector());
    System.out.println(dvd.getPlotOutline());
  }
}