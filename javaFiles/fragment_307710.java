abstract public class Model {
    static final int COORDS_PER_VERTEX = 3;
    protected float coords[];

    public Model(float[] coords){
        this.coords = coords;

        //do some stuff unrelated to the issue
    }
    public void draw(){
        final int vertexCount = coords.length / COORDS_PER_VERTEX;
    }
}

public class Square extends Model {
    public Square(){
        super(new float[] {
            -0.5f, 0.5f, 0.0f, 
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f, 
            0.5f,  0.5f, 0.0f }
        );
    }
}