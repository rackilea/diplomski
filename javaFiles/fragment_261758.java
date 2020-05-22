void setup(){
   Ani.init(this);
}
void mouseReleased(){
   Ani.to(this, 1.5, "rectX", mouseX);
   Ani.to(this, 1.5, "rectY", mouseY);
}