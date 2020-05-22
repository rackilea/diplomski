import ddf.minim.*;
Minim minim;
AudioInput in;

//3s as millis
int interval = 3 * 1000;
int time;

void setup() {
  fullScreen();
  background(255, 60, 80);

  time = millis();

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

  if(millis() - time >= interval){
    // clear background
    background(255, 60, 80);
    // reset time for next interval
    time = millis();
    // debug
    println("=========================>  tick");
  }

}