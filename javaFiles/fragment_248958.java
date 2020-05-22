int n;

void setup(){
  size(displayWidth, displayHeight);
  n = 7;
}
void draw(){
    background(0);
    push();
    translate(displayWidth/2, displayHeight/2);
    strokeWeight(4);

    for (int i=0; i < n; i++){
      stroke(random(255), random(255), random(255));
      //println(i);
      //println("theta is", i*(2*PI/n));
      //println("theta in deg is", i*(2*PI/n)*180/PI);
      push();
      rotate(i*(2.0*PI)/n);
      line(0, 0, 400, 0);
      pop();
    }
    pop();

}

void keyPressed(){
  if (key == '='){
    n++;
  } else if (key == '-'){
    n--;
    if (n <= 0) n = 1;
  } 
}