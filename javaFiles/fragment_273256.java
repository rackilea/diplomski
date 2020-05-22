import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyFrame extends JFrame implements ActionListener
{
    private JComboBox jcbShape;
    private WGraph jpGraph;
    public MyFrame()
    {
        super("GridFrame");
    }
    public void prepareGUI()
    {
        Object[] items= {"Line","Rectangle","Circle"};
        jcbShape = new JComboBox(items);
        jpGraph = new WGraph();
        Container container = getContentPane();
        container.add(jpGraph);
        container.add(jcbShape,BorderLayout.NORTH);
        jcbShape.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String sShape = (String)jcbShape.getSelectedItem();
        jpGraph.setShape(sShape);
    }
    public static void main(String[] st)
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                MyFrame myFrame = new MyFrame();
                myFrame.prepareGUI();
                myFrame.setVisible(true);
            }
        });
    }
}
class WGraph extends JPanel
{
    private String sShape = "Line";
    public void setShape(String shape)
    {
        sShape = shape;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if ("Line".equalsIgnoreCase(sShape))
        {
            g.drawLine(10, 20, 100, 200);
        }
        else if ("Circle".equalsIgnoreCase(sShape))
        {
            g.drawOval(50, 100 , 200, 200);
        }
        else if ("Rectangle".equalsIgnoreCase(sShape))
        {
            g.drawRect(10, 20, 150, 200);
        }
    }
}