PWindow win;

public void settings() {
  size(320, 240);
}

void setup() { 
  win = new PWindow();
}

void draw() {
  background(255, 0, 0);
  text("Click in this window to draw at a relative position in the other window", 10, 10, this.width - 20, 100);
}

void mousePressed() {
  println("mousePressed in primary window");
  float relPosX = map(mouseX, 0, this.width, 0, 100);
  float relPosY = map(mouseY, 0, this.height, 0, 100);
  win.evokedFromPrimary(relPosX, relPosY);
}  

class PWindow extends PApplet {
  ArrayList<PVector> vectors = new ArrayList<PVector>();
  PWindow() {
    super();
    PApplet.runSketch(new String[] {this.getClass().getSimpleName()}, this);
  }

  void evokedFromPrimary(float relPosX, float relPosY) {
    println("evoked from primary");

    float xPos = map(relPosX, 0, 100, 0, this.width);
    float yPos = map(relPosY, 0, 100, 0, this.height);

    vectors.add(new PVector(xPos, yPos));
  }
  void settings() {
    size(500, 200);
  }

  void setup() {
    background(150);
  }

  void draw() {
    background(150);
    //store the vector size before using to avoid ConcurrentModificationException
    int listLength = vectors.size();
    for(int i = 0; i < listLength; i++) {
      PVector v = vectors.get(i);
      ellipse(v.x, v.y, random(50), random(50));
    }

  }

  void mousePressed() {
    println("mousePressed in secondary window");
  }
}