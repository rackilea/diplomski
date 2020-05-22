public class GraphFrame extends JFrame {

private DrawGraph graph;

public GraphFrame(){
    super();
    graph = new DrawGraph();
    this.add(graph);
}
class DrawGraph extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(10, 100, 380, 100);
        g.drawLine(200, 30, 200, 190);

        g.drawLine(380, 100, 370, 90);
        g.drawLine(380, 100, 370, 110);
        g.drawLine(200, 30, 190, 40);
        g.drawLine(200, 30, 210, 40);

        g.drawString("X", 360, 80);
        g.drawString("Y", 220, 40);
        }
    }
}