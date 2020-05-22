import ddf.minim.*;
Minim minim;
AudioInput in;

void setup() {
  //fullScreen();
  size(300,300);
  background(255, 60, 80);

  minim = new Minim(this);
  //minim.debugOn ();
  in = minim.getLineIn(Minim.MONO, 100);
}

void draw() {
  float soundlevel;
  float distance_top = random(100);

  soundlevel = in.mix.get(0);

  stroke(255, random(90, 255));
  line(0, distance_top + soundlevel * 4000, width, distance_top + soundlevel * 1000);
  line(0, distance_top + soundlevel * 1000, width, distance_top + soundlevel * 4000);

  if(frameCount % (3 * 60) == 0){
    // clear background
    background(255, 60, 80);
    // debug
    println("=========================>  tick");
  }

}