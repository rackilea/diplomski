import java.awt.Color;

public class Model {
    private final Controller controller;  // Not used yet
    private final View view;
    private final MvcFrame mvcFrame; // Not used yet

    // Mutators and accessors needed for these guys (set/get)
    private final int radius = 44;
    private final Color color = Color.BLUE;
    private final boolean solid = true;

    public Model() {
        controller = new Controller(this);
        view = new View(this);
        mvcFrame = new MvcFrame(this);
    }

    public View getView() {
        return view;        
    }

    public int getRadius() {
        return radius;      
    }

    public Color getColor() {
        return color;       
    }

    public boolean isSolid() {
        return solid;       
    }
}