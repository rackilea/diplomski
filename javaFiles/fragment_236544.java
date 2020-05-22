public class Player extends ChildComponent {

    @Override
    public void update() {
        // update player
    }

    @Override
    public void render() {
        // render player
    }

}

public class World extends ContainerComponent {

    @Override
    public void update() {
        super.update(); // update world's children (the player)
        // update the world (this can be done either after or before updating children,
        // you choose how to update your world)
    }

    @Override
    public void render() {
        super.render(); // render world's children (the player)
        // render the world (this can be done either after or before rendering children,
       // you choose how to render your world)
    }

}