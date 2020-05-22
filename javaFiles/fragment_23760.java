// YOU GOT ADD (CLICK) AT LEAST 2 POINTS TO SEE IT WORKING ;)

ArrayList<PVector> positions  = new ArrayList<PVector>();

void setup(){
  size(600, 600);

  //if you don't want to see the cursor...
  noCursor();    
}

void draw(){
  //clear screen
  background(255);

  //always draw at mousePosition
  //a "custom cursor"
  //that will not persist as screen is beeing cleared
  fill(200,80,220);
  noStroke();
  ellipse(mouseX, mouseY, 20, 20);

  stroke(80);
  PVector prevP = null;

  for (PVector p:positions) {
    if(prevP != null) {
      line(prevP.x, prevP.y, p.x, p.y);
    }

    prevP = p.get();
  }
}

void mouseClicked() {
  positions.add(new PVector(mouseX, mouseY));
}