abstract class Animal {
 private int energyLevel;
 private String playMessage;
 private String speakMessage;

 ...
 public Animal(String speakMessage, String playMessage) {
  this.speakMessage = speakMessage;
  this.playMessage = playMessage;
 }

 public Animal() {
  this( "Grrr...", "I am loving it" );
 }
 ...
 public abstract void eat( Food f ) throws IllegalArgumentException;

 public void play() {
  System.out.println( playMessage );
  energyLevel += 8;
 }

 public void speak() {
  System.out.println( speakMessage );
  energyLevel -= 1;
 }
..
}