public Jukebox(){
 System.out.println("Constructing Jukebox");
 this.favoritesPL = new Queue<SongEntry>("favorites");
 this.loungePL = new Queue<SongEntry>("loungePL");
 this.roadTripPL = new Queue<SongEntry>("roadTripPL");
 System.out.println(favoritesPL.toString());
  }