abstract public class Model {
    static final int COORDS_PER_VERTEX = 3;
    public Model(){
        //do some stuff unrelated to the issue
    }
    public void draw(){
        final int vertexCount = getCoords().length / COORDS_PER_VERTEX;
    }
    abstract public float[] getCoords();
}

public class Square extends Model {
    private static float Coords[] = {
                -0.5f, 0.5f, 0.0f,   // top left
                -0.5f, -0.5f, 0.0f,   // bottom left
                0.5f, -0.5f, 0.0f,   // bottom right
                0.5f,  0.5f, 0.0f }; // top right
    public Square() {
        super();
        //do something to Coords
    }

    public float[] getCoords() {
        return Coords;
    }
}