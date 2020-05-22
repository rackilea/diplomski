public class Node implements Serializable
{
    private ArrayList<Node> nodes = new ArrayList<Node>();

    public static void main(String[] args) throws Exception
    {
        Node node = new Node();
        int depth = 3000;

        // Add nodes chained down to specified depth
        Node last = node;
        for (int i = 0; i < depth; i++)
        {
            Node temp = new Node();
            last.nodes.add(temp);
            last = temp;
        }

        System.out.println("starting");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        // Below line will cause a stack overflow.
        out.writeObject(node);

        System.out.println("done");
    }
}