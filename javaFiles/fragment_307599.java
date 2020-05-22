public class Guitar  {

  public static void main(String[] args) {
     Artist prince = new Artist();
     Album purpleRain = new Album(prince);
     purpleRain.playLive();
  }
}