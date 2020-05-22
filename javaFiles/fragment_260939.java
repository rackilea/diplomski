import processing.sound.*;
import de.voidplus.leapmotion.*;

LeapMotion leap;
Theremin leapTheremin;

ArrayList<PVector> points; 
PVector handPos;

TriOsc tri;

void setup () {

  size(640,800);

  leap = new LeapMotion(this);
  points = new ArrayList<PVector>();

  tri = new TriOsc(this);    

  leapTheremin = new Theremin(tri);

}

void draw() {

  leapTheremin.renderSound();

  for (Hand hand : leap.getHands()) {

      handPos = hand.getPosition(); 
      boolean handIsLeft = hand.isLeft();
      boolean handIsRight = hand.isRight();

      if (handPos.z <= 75) {
       points = new ArrayList<PVector>();
       points.add(new PVector(handPos.x, handPos.y));
       background((handPos.x)/2.5,(width-handPos.x)/3,handPos.y-(height/3.5));
      }

       if (hand.isRight()) {
        leapTheremin.setPitch();
   }

      if (hand.isLeft()) {
        leapTheremin.setVolume();
      }   
   }
}

class Theremin {

float freq;
float amp;
int sound;

Theremin (TriOsc tri_g) {

  setPitch();

  sound = 1;

  tri = tri_g;

}

  void setPitch () {

    for (int i = points.size()-1; i >= 0; i--) {
    PVector p = points.get(i);
    freq = map((height-handPos.y)+10, 0, height, 40, 880); //"upright antenna", aka "the right one that controls pitch"
    // To match the colors with the moaods of the pitches   

    }   
  }

  void setVolume() {

    for (int i = points.size()-1; i >= 0; i--) {
    PVector p = points.get(i);
    amp = map(width-p.x, 0, width, 1, .01); //"loop antenna", aka "the left one that controls volume" 

    }
  }

  void renderSound() {
    tri.freq(freq);
    tri.amp(amp);
    tri.play();

  }
}