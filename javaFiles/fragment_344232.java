public class Map {
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;

    private List<Island> islands = new ArrayList<Island>();

    public void generate() {
        // TODO: If you want to make more, make a for loop.
        int radius = 100;
        Island island = new Island(new Point2D(WIDTH / 2, HEIGHT / 2), radius);
        // TODO: If you are going to add more, then you can't simply add them
        // all willy-nilly. You are going to have to check if the islands collide
        // and, if they do, find a way to handle that.
        // You could let them collide and create a mountain range where they do, or,
        // you could try to place the next island in a different position (similar
        // to what we used above placing deposits, but both situations require
        // code a bit better than what I've included).
        islands.add(island);
     }
}