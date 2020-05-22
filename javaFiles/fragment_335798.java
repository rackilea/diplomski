public class EdgeNodeFactory
{
    private boolean[][] edgeMatrix = new boolean[100][100];
    private int edgeCount = 0;
    private int nodeCount = -1;
    private List<Node> nodes = new ArrayList<Node>();
    private List<Node> edges = new ArrayList<Edge>();

    public EdgeNodeFactory()
    {
        // You *could* put your for loop here... but the array
        // elements will all be false anyway, as that's the default...

        // If you don't need any code in this constructor, and you
        // don't declare any other constructors, you can remove it
        // entirely - the compiler will create it by default.
    }

    // Other methods here
}