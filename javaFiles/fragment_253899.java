import edu.uci.ics.jung.visualization.VisualizationImageServer;

...

// Create the VisualizationImageServer
// vv is the VisualizationViewer containing my graph
VisualizationImageServer<Node, Edge> vis =
    new VisualizationImageServer<Node, Edge>(vv.getGraphLayout(),
        vv.getGraphLayout().getSize());

// Configure the VisualizationImageServer the same way
// you did your VisualizationViewer. In my case e.g.

vis.setBackground(Color.WHITE);
vis.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<Edge>());
vis.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<Node, Edge>());
vis.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Node>());
vis.getRenderer().getVertexLabelRenderer()
    .setPosition(Renderer.VertexLabel.Position.CNTR);

// Create the buffered image
BufferedImage image = (BufferedImage) vis.getImage(
    new Point2D.Double(vv.getGraphLayout().getSize().getWidth() / 2,
    vv.getGraphLayout().getSize().getHeight() / 2),
    new Dimension(vv.getGraphLayout().getSize()));

// Write image to a png file
File outputfile = new File("graph.png");

try {
    ImageIO.write(image, "png", outputfile);
} catch (IOException e) {
    // Exception handling
}