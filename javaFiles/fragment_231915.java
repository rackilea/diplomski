import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.commons.collections15.Predicate;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.BasicEdgeRenderer;
import edu.uci.ics.jung.visualization.transform.shape.GraphicsDecorator;

public class JungPerformance 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graph<String, String> g = createGraph();

        Dimension size = new Dimension(800,800);
        VisualizationViewer<String, String> vv = 
            new VisualizationViewer<String, String>(
                new FRLayout<String, String>(g, size));
        DefaultModalGraphMouse<String, Double> graphMouse = 
            new DefaultModalGraphMouse<String, Double>();
        vv.setGraphMouse(graphMouse); 

        improvePerformance(vv);

        f.getContentPane().add(vv);
        f.setSize(size);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    // This method summarizes several options for improving the painting
    // performance. Enable or disable them depending on which visual features
    // you want to sacrifice for the higher performance.
    private static <V, E> void improvePerformance(
        VisualizationViewer<V, E> vv)
    {
        // Probably the most important step for the pure rendering performance:
        // Disable anti-aliasing
        vv.getRenderingHints().remove(RenderingHints.KEY_ANTIALIASING);

        // Skip vertices that are not inside the visible area. 
        doNotPaintInvisibleVertices(vv);

        // May be helpful for performance in general, but not appropriate 
        // when there are multiple edges between a pair of nodes: Draw
        // the edges not as curves, but as straight lines:
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<V,E>());

        // May be helpful for painting performance: Omit the arrow heads
        // of directed edges
        Predicate<Context<Graph<V, E>, E>> edgeArrowPredicate = 
            new Predicate<Context<Graph<V,E>,E>>()
        {
            @Override
            public boolean evaluate(Context<Graph<V, E>, E> arg0)
            {
                return false;
            }
        };
        vv.getRenderContext().setEdgeArrowPredicate(edgeArrowPredicate);

    }

    // Skip all vertices that are not in the visible area. 
    // NOTE: See notes at the end of this method!
    private static <V, E> void doNotPaintInvisibleVertices(
        VisualizationViewer<V, E> vv)
    {
        Predicate<Context<Graph<V, E>, V>> vertexIncludePredicate = 
            new Predicate<Context<Graph<V,E>,V>>()
        {
            Dimension size = new Dimension();

            @Override
            public boolean evaluate(Context<Graph<V, E>, V> c)
            {
                vv.getSize(size);
                Point2D point = vv.getGraphLayout().transform(c.element);
                Point2D transformed = 
                    vv.getRenderContext().getMultiLayerTransformer()
                        .transform(point);
                if (transformed.getX() < 0 || transformed.getX() > size.width)
                {
                    return false;
                }
                if (transformed.getY() < 0 || transformed.getY() > size.height)
                {
                    return false;
                }
                return true;
            }
        };
        vv.getRenderContext().setVertexIncludePredicate(vertexIncludePredicate);

        // NOTE: By default, edges will NOT be included in the visualization
        // when ONE of their vertices is NOT included in the visualization.
        // This may look a bit odd when zooming and panning over the graph.
        // Calling the following method will cause the edges to be skipped
        // ONLY when BOTH their vertices are NOT included in the visualization,
        // which may look nicer and more intuitive
        doPaintEdgesAtLeastOneVertexIsVisible(vv);
    }

    // See note at end of "doNotPaintInvisibleVertices"
    private static <V, E> void doPaintEdgesAtLeastOneVertexIsVisible(
        VisualizationViewer<V, E> vv)
    {
        vv.getRenderer().setEdgeRenderer(new BasicEdgeRenderer<V, E>()
        {
            @Override
            public void paintEdge(RenderContext<V,E> rc, Layout<V, E> layout, E e) 
            {
                GraphicsDecorator g2d = rc.getGraphicsContext();
                Graph<V,E> graph = layout.getGraph();
                if (!rc.getEdgeIncludePredicate().evaluate(
                        Context.<Graph<V,E>,E>getInstance(graph,e)))
                    return;

                Pair<V> endpoints = graph.getEndpoints(e);
                V v1 = endpoints.getFirst();
                V v2 = endpoints.getSecond();
                if (!rc.getVertexIncludePredicate().evaluate(
                        Context.<Graph<V,E>,V>getInstance(graph,v1)) && 
                    !rc.getVertexIncludePredicate().evaluate(
                        Context.<Graph<V,E>,V>getInstance(graph,v2)))
                    return;

                Stroke new_stroke = rc.getEdgeStrokeTransformer().transform(e);
                Stroke old_stroke = g2d.getStroke();
                if (new_stroke != null)
                    g2d.setStroke(new_stroke);

                drawSimpleEdge(rc, layout, e);

                // restore paint and stroke
                if (new_stroke != null)
                    g2d.setStroke(old_stroke);
            }
        });
    }


    public static Graph<String, String> createGraph() 
    {
        Random random = new Random(0);
        int numVertices = 2500;
        int numEdges = 5000;
        Graph<String, String> g = new DirectedSparseGraph<String, String>();
        for (int i=0; i<numVertices; i++)
        {
            g.addVertex("v"+i);
        }
        for (int i=0; i<numEdges; i++)
        {
            int v0 = random.nextInt(numVertices);
            int v1 = random.nextInt(numVertices);
            g.addEdge("e"+i, "v"+v0, "v"+v1);
        }
        return g;
    }    
}