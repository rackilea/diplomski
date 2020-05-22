public class Foo {
   public Foo() {
      ...
   }

    public static void updateBuffer(Image image, int XPos , int YPos , int Height , int Width , int Rotation, AffineTransform trans, Foo foo) {
        trans.translate(XPos,YPos);
        trans.rotate(Rotation);      //More lines will probably be more lines totransform the shape more as the game gets more advanced
        g2d.drawImage(image,trans,foo); // <-- 'foo' stands in for 'this'

   }

   public static void main(String[] args) {
      Image i = new Image();
      int x,y,h,w,r;
      AffineTransform t = new AffineTransform();
      Foo f = new Foo();
      Foo.updateBuffer(i,x,y,h,w,r,t,f);
   }
}