public interface GameComponent {

    void render();

    void update();
}

public abstract class ChildComponent implements GameComponent {

    protected ContainerComponent parent; // (see below)

    // getter and setter for parent
}

public class ContainerComponent implements GameComponent {

    protected List<GameComponent> children = new ArrayList<>();

    public void add(GameComponent child) {
        this.children.add(child);
        child.setParent(this);
    }

    @Override
    public void update() {
        for (GameComponent c : this.children) {
            c.update();
        }
    }

    @Override
    public void render() {
        for (GameComponent c : this.children) {
            c.render();
        }
    }

}