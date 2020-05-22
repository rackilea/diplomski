public class HelloWorld extends JFrame
{
    private static final long serialVersionUID = -2707712944901661771L;

    public HelloWorld()
    {
        super("Hello, World!");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            String s1 = "Hello";
            String s2 = "World!";
            Object v1 = graph.insertVertex(parent, "ID1", s1, 20, 20, 80, 30);
            Object v2 = graph.insertVertex(parent, "ID2", s2, 240, 150, 80, 30);
            Object edge = graph.insertEdge(parent, "ID3", "TEST", v1, v2);
        }
        finally
        {
            graph.getModel().endUpdate();
        }
        final mxGraphComponent graphComponent = new mxGraphComponent(graph);

        graphComponent.getGraphControl().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell instanceof mxCell)
                {
                    System.out.println(((mxCell) cell).getValue());
                }
            }
        });
        getContentPane().add(graphComponent);
    }

    public static void main(String[] args)
    {
        HelloWorld frame = new HelloWorld();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}