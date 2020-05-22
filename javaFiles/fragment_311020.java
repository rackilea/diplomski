PShape s;

boolean useFill;

void setup(){

  size(300,300);
  s = createShape();
  s.beginShape();
  s.noFill();
  s.vertex(30,30);
  s.vertex(120,30);
  s.vertex(30,120);
  s.vertex(30,30);// close shape, repeat last vertex
  s.endShape();

}

void draw(){
  background(127 + (frameCount % 127));
  shape(s);
  text("press any key to toggle fill",10,15);
}

void keyPressed(){
  useFill = !useFill;

  if(useFill){
    s.beginShape();
    s.fill(color(192,0,0));
    s.endShape();
  }else{
    s.beginShape();
    s.noFill();
    s.endShape();
  }
}