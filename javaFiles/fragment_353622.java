public class Vertex {
    private double x;
    private double y;
    public Vertex(double x, double y) { 
        this.x = x;
        this.y = y;
    }

public class TriangleVertices {
    private vertexA;
    private vertexB;
    private vertexC;
    public TriangleVertices (Vertex a, Vertex b, Vertex c) {
        vertexA = a;
        vertexB = b;
        vertexC = c;
    }
}

public class Triangle {
    private TriangleVertices vertices;
    // other attributes

    // You have now 5 arguments less!
    public Triangle(TriangleVertices vertices, // other attributes) {
        this.vertices = vertices;
        // Initialize other attributes
    }
}