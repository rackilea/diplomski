// Triangle Class
 public class Triangle {  
      public Point points[] = {new Point(), new Point(), new Point()};
 }

 Triangle currentTriangle = new Triangle();
 int trianglePointIndex = 0;
 List<Triangle> triangleList = new ArrayList<Triangle>();
 GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
 for (float z=0.0f; z<=20.0f; z+=2.0f) {
      for (float x=0.0f; x<=20.0f; x+=2.0f) {
           GL11.glVertex3f(x, 0.0f, z); 

           Point currentPoint = currentTriangle.points[ trianglePointIndex ];
           currentPoint.x = x;
           currentPoint.y = 0.0f;
           currentPoint.z = z;

           trianglePointIndex++;

           if (trianglePointIndex == 3) {
                triangleList.add( currentTriangle );
                Triangle nextTriangle = new Triangle();
                nextTriangle.points[0].set( currentTriangle.points[1] );
                nextTriangle.points[1].set( currentTriangle.points[2] );
                currentTriangle = nextTriangle;
                trianglePointIndex = 2;
           }
      }
 }
 GL11.glEnd();