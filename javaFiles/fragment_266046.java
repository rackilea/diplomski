public class MyShape{
   PApplet papplet;

   public MyShape(PApplet papplet){
      this.papplet = papplet;
   }

   public void draw(){
      papplet.ellipse(50, 50, 25, 25);
   }
}