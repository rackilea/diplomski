int circleX, circleY; 

 // Position of circle button 
 int circleSize = 93;  

  // Diameter of circle
color circleColor, baseColor;
color circleHighlight;
color currentColor;

boolean color1 = false;

int start;int m = 0;


void setup() {
    start = millis();
    size(640, 360);
    circleColor = color(255);
    circleHighlight = color(204);
    baseColor = color(102);
    currentColor = baseColor;
    circleX = width/2+circleSize/2+10;
    circleY = height/2;
    ellipseMode(CENTER);
    }


void draw() {
    if (color1){
        currentColor = color(255);
    }else{
        currentColor = color(85);
    }
    background(currentColor);

    if (overCircle(circleX, circleY, circleSize)) {
    fill(circleHighlight);} else {
    fill(circleColor);}
    stroke(0);
    ellipse(circleX, circleY, circleSize, circleSize);
    int timer = millis()-start;
    fill(0, 102, 153);
    textSize(40);
    text(timer, 40, 40);
    textSize(20);
    text("milliseconds", 200,40);

    fill(0,102,153);
    textSize(40);
    text(m,400,40);
    textSize(20);
    text("hits", 450,40);
}


void mousePressed() {
    if (overCircle(circleX, circleY, circleSize)) {
      color1 = !color1;
      m = m + 1;
      }
    }

boolean overCircle(int x, int y, int diameter) {
    float disX = x - mouseX;
    float disY = y - mouseY;
    if (sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
        return true;
        } else {
            return false;
            }
    }