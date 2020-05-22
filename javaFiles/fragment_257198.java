private class PaintSurface extends JComponent {
   ...
   //Polygon triangle;
   List<Polygon> triangles = new LinkedList<Polygon>();
   ...

   public PaintSurface() {

      public void mouseReleased(MouseEvent e) {
         ...
         //triangle = new Polygon(xs, ys, 3);
         triangles.add( new Polygon(xs, ys, 3); );
         ...
        }
     });
     ...
  }

  public void paint(Graphics g) {
     ...
     //g2.fillPolygon(triangle);
     for (Polygon triangle : triangles) g2.fillPolygon(triangle);
     ...
   }
}