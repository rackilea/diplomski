import java.awt.Color;
import java.awt.Paint;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class JUNGEdgeColorsTest 
{

    public static void main(String[] args) 
    {
        JFrame jf = new JFrame();
        final Graph<String, String> g = getGraph();
        VisualizationViewer<String, String> vv = 
            new VisualizationViewer<String, String>(new FRLayout<String, String>(g));

        Transformer<String, Paint> colorTransformer = new Transformer<String, Paint>()
        {
            @Override
            public Paint transform(String e)
            {
                final String s = g.getSource(e);
                final String d = g.getDest(e);
                if (s.equals("v1") && d.equals("v0"))
                {
                    return Color.GREEN;
                }
                return Color.BLACK;
            }
        };
        vv.getRenderContext().setArrowFillPaintTransformer(colorTransformer);
        vv.getRenderContext().setArrowDrawPaintTransformer(colorTransformer);
        vv.getRenderContext().setEdgeDrawPaintTransformer(colorTransformer);
        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
    public static Graph<String, String> getGraph() 
    {
        Graph<String, String> g = new DirectedSparseGraph<String, String>();
        g.addVertex("v0");
        g.addVertex("v1");
        g.addEdge("e0", "v0", "v1");
        g.addEdge("e1", "v1", "v0");
        return g;
    }
}