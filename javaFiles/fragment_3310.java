package test;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.PickedState;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

public class Test2 {
public static void main(String args[])
{
Graph graph = new DirectedSparseMultigraph<String, String>();
graph.addEdge("Edge 1", "Peer 1", "Peer 2");
graph.addEdge("Edge 2", "Peer 2", "Peer 3");
graph.addEdge("Edge 3", "Peer 3",  "Peer 1");
Layout<String, String> layout = new CircleLayout(graph);
VisualizationViewer<String, String> tempViewer = new VisualizationViewer<>(layout);
tempViewer.setPreferredSize(new Dimension(700,700));
tempViewer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
tempViewer.setVertexToolTipTransformer(new ToStringLabeller());
tempViewer.getRenderContext().setArrowFillPaintTransformer(new ConstantTransformer(Color.lightGray));
DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
tempViewer.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Orthogonal<String, String>()); // If I comment this line, the program works perfectly fine
graphMouse.setMode(ModalGraphMouse.Mode.PICKING);
Transformer<String, Paint> edgePaint = new Transformer<String, Paint>() {

    @Override
    public Paint transform(String graphEdge) {
        int redValue = Math.abs(graphEdge.hashCode() % 235);
        int greenValue = Math.abs(graphEdge.hashCode() % 205);
        int blueValue = Math.abs(graphEdge.hashCode() % 175);

        return new Color(redValue, greenValue, blueValue); 
    }
};
tempViewer.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
tempViewer.setGraphMouse(graphMouse);

final PickedState<String> pickedState = tempViewer.getPickedEdgeState();
        pickedState.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object subject = e.getItem();
                if (subject instanceof String) {
                    String edgePicked = (String) subject;
                    if (pickedState.isPicked(edgePicked)) {
                        Graph newGraph = new DirectedSparseGraph<String, String>();
                        newGraph.addEdge("Edge 5", "Peer 1 ", "Peer 2");
                        newGraph.addEdge("Edge 6", "Peer 2", "Peer 3");
                        newGraph.addEdge("Edge 7", "Peer 3", "Peer 1");
                        Layout<String, String> graphlayout = new CircleLayout(newGraph);
                        VisualizationViewer chartViewer = new VisualizationViewer<>(graphlayout);
                        JPanel tempPanel = new JPanel();
                        tempPanel.add(chartViewer);

                        JFrame tempFrame = new JFrame("Sample Data ");
                        tempFrame.getContentPane().add(tempPanel);
                        tempFrame.pack();
                        tempFrame.setVisible(true);       

                    }
                }
            }
        });
        JPanel graphPanel = new JPanel(new BorderLayout());
        graphPanel.add(tempViewer, BorderLayout.CENTER);
        JPanel controlPanel = addLegendControls(tempViewer, graph);
        graphPanel.add(controlPanel, BorderLayout.SOUTH);

        JFrame masterFrame = new JFrame();
        masterFrame.add(graphPanel);
        masterFrame.pack();
        masterFrame.setVisible(true);
}


static JPanel addLegendControls(VisualizationViewer chartViewer, Graph tempGraph)
{
   JPanel masterPanel = new JPanel(new BorderLayout());
JPanel secondPanel = new JPanel(new GridLayout(1, 2));
DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
chartViewer.setGraphMouse(graphMouse);
JComboBox modeBox = graphMouse.getModeComboBox();
modeBox.addItemListener(graphMouse.getModeListener());
graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);

final ScalingControl scalerGraph = new CrossoverScalingControl();
JButton zoomPlus = new JButton("+");
zoomPlus.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        scalerGraph.scale(chartViewer, 1.1f, chartViewer.getCenter());
    }
});
JButton zoomMinus = new JButton("-");
zoomMinus.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        scalerGraph.scale(chartViewer, 1 / 1.1f, chartViewer.getCenter());
    }
});

final int defaultRowSize = 10;
JPanel legendBox = new JPanel(new GridLayout(defaultRowSize, 1));
int borderThickness = 2;
legendBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
JLabel legendLabel = new JLabel("    LEGEND     ");
legendBox.add(legendLabel);
Collection<String> graphEdges = tempGraph.getEdges();
for ( String graphLabel : graphEdges) {
    Color edgeColor = (Color)chartViewer.getRenderContext().getEdgeDrawPaintTransformer().transform(graphLabel);
    JPanel circlePanel = new JPanel() {
        protected void paintComponent(Graphics g) { 
            super.paintComponent(g); 
            g.setColor(edgeColor);
            g.fillOval(2, 9, 10, 10); 
        } 
    };

    JLabel edgeLabel = new JLabel("      " + graphLabel + "   Sent From: " + tempGraph.getSource(graphLabel) + "  To : " + tempGraph.getDest(graphLabel));
    circlePanel.add(edgeLabel);
    legendBox.add(circlePanel); 
}

JPanel modePanel = new JPanel(new GridLayout(1, 1));
modePanel.setBorder(BorderFactory.createTitledBorder("Mouse Mode"));
modePanel.add(modeBox);
secondPanel.add(modePanel);
JPanel zoomPanel = new JPanel(new GridLayout(1, 2));
zoomPanel.setBorder(BorderFactory.createTitledBorder("Manual Zoom Controls"));
zoomPanel.add(zoomPlus);
zoomPanel.add(zoomMinus);
secondPanel.add(zoomPanel);
masterPanel.add(secondPanel, BorderLayout.SOUTH);
masterPanel.add(legendBox, BorderLayout.EAST);
return masterPanel;
   }
}