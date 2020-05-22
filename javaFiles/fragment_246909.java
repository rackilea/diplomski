public class Triangle {

    public static class Vertex2D {

        private float x;
        public Vertex2D(float i, float j) {
            x=i;
            y=j;
        }



        public float getX() {
            return x;
        }



        public void setX(float x) {
            this.x = x;
        }



        public float getY() {
            return y;
        }



        public void setY(float y) {
            this.y = y;
        }



        private float y;

        public double distance(Vertex2D vertex2d) {
            float x1=vertex2d.x-x;
            float y1=vertex2d.y-y;

            return Math.sqrt(x1*x1+y1*y1);
        }



        public Vertex2D createMiddle(Vertex2D vertex2d) {
            float x1=vertex2d.x+x;
            float y1=vertex2d.y+y;

            Vertex2D v=new Vertex2D(x1, y1);
            v.setX(x1);
            v.setY(y1);


            return v;
        }

    }

    private static final int NUM_OF_SUB_TRIANGLES = 3;
    private final Vertex2D[] vertices = new Vertex2D[3];
    private final Triangle[] subTriangles = new 
Triangle[NUM_OF_SUB_TRIANGLES];
    public  Triangle(Vertex2D v1, Vertex2D v2, Vertex2D v3){
        vertices[0] = v1;
        vertices[1] = v2;
        vertices[2] = v3;
    }

// Method returns a vertex of the triangle according to input index
public Vertex2D getVertex(int index) {
    for (int i = 0; i < 3; i++) {
        if (index == i) {
            return vertices[i];
        }
    }
    return null;
}

public boolean isEquilateral(){
    double side1 = vertices[0].distance(vertices[1]);
    double side2 = vertices[0].distance(vertices[2]);
    double side3 = vertices[1].distance(vertices[2]);

    if(Math.abs(side1-side2) < 0.001 && Math.abs(side1-side3) < 0.001 && Math.abs(side2-side3) < 0.001){
        return true;
    }else{
        return false;
    }

}

// Method outputs the coordinates of threes vertices of the triangle
// edit this one
public String toString(){
    String s = "Triangle: vertices=" + vertices[0]
            + " [" + vertices[1].getX() + ", " + vertices[1].getY() + "] " + "[" + vertices[2].getX() + ", " + vertices[2].getY()
            + "]";
    return s;
}

// Method checks if the three sub triangles are created
public boolean isDivided(){
    for(int i = 0 ; i < NUM_OF_SUB_TRIANGLES; i ++){
        if(subTriangles[i] == null){
            return false;
        }
    }
    return true;
}

// Method returns a sub triangle according to the input index
public Triangle getSubTriangle(int index){
    for (int i = 0; i < 3; i++) {
        if (index == i) {
            return subTriangles[i];
        }
    }
    return null;
}

public static void main(String args[]) {
    Vertex2D v1=new Vertex2D(10,20);
    Vertex2D v2=new Vertex2D(-10,-20);
    Vertex2D v3=new Vertex2D(10,-20);
    Triangle t=new Triangle(v1, v2, v3);

    boolean r = t.divide(3);
    System.out.println(r);

}

// Method divides the triangle into three sub triangles

public boolean divide(){
    if (isDivided()){
        return false;
    }else{
        // Find vertices of the three sub triangles
        Triangle t1 = new Triangle(vertices[0], vertices[0].createMiddle(vertices[1]), vertices[0].createMiddle(vertices[2]));
        Triangle t2 = new Triangle(vertices[0].createMiddle(vertices[1]), vertices[1], vertices[1].createMiddle(vertices[2]));
        Triangle t3 = new Triangle(vertices[0].createMiddle(vertices[2]), vertices[1].createMiddle(vertices[2]), vertices[2]);

        subTriangles[0] = t1;
        subTriangles[1] = t2;
        subTriangles[2] = t3;

        return true;
    }
}

public boolean divide(int depth){
    if(depth <= 0){
        return false;
    }else{
        while(depth > 0) {
            if (!isDivided()) {
                divide();
            } else {
                depth -= 1;
                for (int i = 0; i < 3; i++) {
                    Triangle t = getSubTriangle(i);
                    System.out.println(t.toString());
                            if (t!=null) {
                                t.divide(depth);
                            }
                }
                depth -= 1;
            }
        }
        return true;
    }

}
}