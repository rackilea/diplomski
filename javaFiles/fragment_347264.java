public class Dummy {
   public static void main(String[] args) {
      Gamma g = new Gamma();

      Alpha a = new Alpha(g);
      Beta b = new Beta(g);

      // .........


   }
}

class Alpha {
   private Gamma g;

   public Alpha(Gamma g) {
      this.g = g;
   }

   public int getGammaX() {
      return g.getX();
   }

   public void setGammaX(int x) {
      g.setX(x);
   }
}

class Beta {
   // Gamma g = new Gamma();
   private Gamma g;

   public Beta(Gamma g) {
      this.g = g;
   }

   public int getGammaX() {
      return g.getX();
   }

   public void setGammaX(int x) {
      g.setX(x);
   }
}

class Gamma {
   int x = 10;

   public int getX() {
      return x;
   }

   public void setX(int y) {
      x = y;
   }
}