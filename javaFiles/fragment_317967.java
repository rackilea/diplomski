public class Painter {
    private List<Paintable> paintableObjects;

    public Painter(){
       paintableObjects = new ArrayList<Paintable>();
    }

    public void paintAllObjects(){
        for(Paintable paintable : paintableObjects){
            paintable.paint();
        }
    }
}

public interface Paintable {
     public void paint();
}