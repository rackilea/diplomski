MP3 mp3 = new MP3(this.getClass().getResourceAsStream("YGSA.mp3"));
mp3.play();


 public MP3(InputStream filename) {
   this.filename = filename;

 }
public void play() {
try {
    BufferedInputStream bis = new BufferedInputStream(fis);
    player = new Player(bis);
}
catch (Exception e) {
    System.out.println("Problem playing file " + filename);
    System.out.println(e);
}