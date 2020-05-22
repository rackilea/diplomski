public class ZoomableZestGraph extends Composite {

private GraphViewer graphViewer;
private Graph graph;

public ZoomableZestGraph(Composite parent, int style) {
    super(parent, style);
    this.setLayout(new GridLayout(1, true));    
    this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,1));


    //create a GraphViewer and Graph
    graphViewer = new GraphViewer(this, SWT.V_SCROLL | SWT.H_SCROLL);
    graph = graphViewer.getGraphControl();
    graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
    graph.setHorizontalScrollBarVisibility(Graph.ALWAYS);
    graph.setVerticalScrollBarVisibility(Graph.ALWAYS);


    //Fill our graph with some nodes and connect them
    GraphNode node1 = new GraphNode(graph, SWT.NONE, "Earendil");
    GraphNode node2 = new GraphNode(graph, SWT.NONE, "Elros");
    GraphNode node3 = new GraphNode(graph, SWT.NONE, "Elrond");
    GraphNode node4 = new GraphNode(graph, SWT.NONE, "Elladan");
    GraphNode node5 = new GraphNode(graph, SWT.NONE, "Elrohir");
    GraphNode node6 = new GraphNode(graph, SWT.NONE, "Arwen");


    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node3);
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node2, node4);
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node2, node5);
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node2, node6);

    /*
    This graphViewer consists of 2 components: the control and the graph (Figure)
    We want to give the control a size by the layout and the graph a custom, bigger value.
    For the control (graphViewer.getControl) I simply grab all available space
    */
    GridDataFactory.fillDefaults().grab(true, true).applyTo(graphViewer.getControl());

    //For the graph we have to create a PaintListener.
    graph.addPaintListener(new PaintListener() {

        @Override
        public void paintControl(PaintEvent e) {
        graph.setSize(1300, 1080);

        }
    });
    //The Graph now fills the shell/parent composite, 
    //but the actual graph size can be set as we want in the paint //listener

    //Zooming with the class org.eclipse.gef.editparts.ZoomManager
    //As arguments we need a ScalableFigure which we receive by graph.getRootLayer and the Viewport.
    ZoomManager zoomManager = new ZoomManager(graph.getRootLayer(), graph.getViewport());

    //we bind the zoom mechanic to a simple mouse wheel listener
    graph.addMouseWheelListener(new MouseWheelListener() {

        @Override
        public void mouseScrolled(MouseEvent e) {
            if (e.count < 0) {
                zoomManager.zoomOut();
            } else {
                zoomManager.zoomIn();
            }
        }
    });
    //We give the focus to our graphViewer, so it receives the MouseWheel Events
    graphViewer.getControl().forceFocus();
    }

   @Override
   protected void checkSubclass() {
     //we are a composite subclass
   }

}