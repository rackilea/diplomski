abstract class DancerAnimal extends Animal {
 private String danceMessage;

 public DancerAnimal(String speakMessage, String playMessage, String danceMessage) {
  super( speakMessage, playMessage );
  this.danceMessage = danceMessage;
 }

 public DancerAnimal( String danceMessage ) {
   super();
   this.danceMessage = danceMessage;
 }

 public void dance() {
  System.out.println( danceMessage );
 }
...
}