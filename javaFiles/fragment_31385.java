import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputAdapter;

public class DragDemo extends JFrame {

    private static int NAX_COMP_COUNT = 3;

    public DragDemo() {
        setTitle("Drag Demo");
        setLayout(new GridLayout(1,3));

        //demonstrates adding components to a null layout panel, with a button click
        JPanel panelA = new CustomPanel("Add components,Null layout");
        add(panelA);

        //adds drsg support to the above
        JPanel panelB = new CustomPanel("Add components,Null layout, Drag", true);
        add(panelB);

        //demonstrates adding components to a flow layout panel, with a button click
        //you can add drag support, but components will be auto-layout when repainted
        JPanel panelC = new CustomPanel("Add components, Flow layout", new FlowLayout());
        add(panelC);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {    new DragDemo(); }

    private class CustomPanel extends JPanel {

        private final BevelBorder border =  new BevelBorder(BevelBorder.RAISED);
        private final int W =250, H = 200, GAP = 5;
        private int originX =10, originY = 10;
        private int compCounter = 0;
        private JPanel centerPane ;
        private LayoutManager layoutManager;
        private boolean isDragSupport = false;

        CustomPanel(String title) { this(title, null, false); }

        CustomPanel(String title, boolean isDragSupport ) {
            this(title,null, isDragSupport);
        }

        CustomPanel(String title, LayoutManager layoutManager) {
            this(title,layoutManager, false);
        }

        CustomPanel(String title, LayoutManager layoutManager, boolean isDragSupport) {

            this.layoutManager = layoutManager;
            this.isDragSupport = isDragSupport;
            TitledBorder tBorder = new TitledBorder(border, title);
            setBorder(tBorder);
            setLayout(new BorderLayout(GAP,GAP));
            JButton button = new JButton("Add Label");
            button.addActionListener( e-> addComponenet());
            add(button, BorderLayout.SOUTH);
            centerPane = new JPanel();
            centerPane.setPreferredSize(new Dimension(W, H));
            centerPane.setLayout(layoutManager);
            add(centerPane, BorderLayout.CENTER);
        }

        private void addComponenet() {
            if( ++ compCounter <= NAX_COMP_COUNT) {
                centerPane.add(getComponent());
                centerPane.getParent().revalidate();
                centerPane.repaint();
            }
        }

        private Component getComponent() {
            JLabel label = new JLabel(""+ compCounter, SwingConstants.CENTER);
            label.setBorder(border);
            if(isDragSupport) {
                DragListener drag = new DragListener();
                label.addMouseListener( drag );
                label.addMouseMotionListener( drag );
            }

            if(layoutManager == null) {//if no layout manger set bounds
                label.setBounds(originX, originY, W/5, H/5);
                originX +=W/5; originY += H/5; //update origin of next component
            }else {
                label.setPreferredSize(new Dimension(W/5, H/5));
            }
            return label;
        }
    }

    //source: https://tips4java.wordpress.com/2009/06/14/moving-windows/
    private class DragListener extends MouseInputAdapter    {

        Point location;
        MouseEvent pressed;

        @Override
        public void mousePressed(MouseEvent me) { pressed = me;  }

        @Override
        public void mouseDragged(MouseEvent me)    {
            Component component = me.getComponent();
            location = component.getLocation(location);
            int x = (location.x - pressed.getX()) + me.getX();
            int y = (location.y - pressed.getY()) + me.getY();
            component.setLocation(x, y);
         }
    }
}