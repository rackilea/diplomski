public class TickAndPaint
{
   public static void main(String[] args) {
      ArrayList<TickableAndPaintable> list = new ArrayList<>();
      for( Paintable t : list ) {
      }
      for( Tickable t : list ) {
      }
   }
}

interface Paintable {}
interface Tickable {}
interface TickableAndPaintable extends Paintable, Tickable {}