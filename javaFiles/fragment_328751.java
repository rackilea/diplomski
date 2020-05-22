public class Polygon {
     private int _vertNum;
     private Point1[] _vertex;

     public Polygon(int verts) {
         _vertNum = verts;
         _vertex = new Point1[_vertNum];

         for(int i = 0 ; i < verts ; i++) {
             _vertex[i] = new Point1(0,0);
         }
     }
 }