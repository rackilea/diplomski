import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import javax.swing.plaf.basic.*;

class LayerList extends JPanel
{
    LayerList()
    {
        LayerUI<JComponent> layerUI = new LayerUI<JComponent>()
        {
            public void paint(Graphics g, JComponent c)
            {
                super.paint(g, c);

                JLayer layer = (JLayer)c;
                JList list = (JList)layer.getView();
                int selected = list.getSelectedIndex();

                if (selected == -1 ) return;

                Rectangle area = list.getCellBounds(selected, selected);

                g.drawString("X", area.width - 15, area.y + area.height - 3);
            }

            public void installUI(JComponent c)
            {
                super.installUI(c);

                JLayer jlayer = (JLayer)c;
                jlayer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
            }

            public void uninstallUI(JComponent c)
            {
                super.uninstallUI(c);

                // reset the layer event mask
                ((JLayer) c).setLayerEventMask(0);
            }

            @Override
            protected void processMouseEvent(MouseEvent e, JLayer l)
            {
//              e.consume();

                if (e.getID() == MouseEvent.MOUSE_RELEASED)
                {
                    JList list = (JList)e.getComponent();
                    int selected = list.getSelectedIndex();
                    Rectangle area = list.getCellBounds(selected, selected);

                    if (e.getX() >= area.width - 15)
                    {
                        e.consume();
                        DefaultComboBoxModel model = (DefaultComboBoxModel)list.getModel();
                        model.removeElementAt( selected );
                        list.setSelectedIndex(selected);
                    }
                }
            }
        };

        String[] data = { "a", "b", "c", "d", "e", "f" };

        JComboBox<String> comboBox = new JComboBox<String>(data);

        Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup)child;
        JList list = (JList)popup.getList();
        Container c = SwingUtilities.getAncestorOfClass(JScrollPane.class, list);
        JScrollPane scrollPane = (JScrollPane)c;
        scrollPane.setViewportView( new JLayer<JComponent>(list, layerUI) );


        setLayout( new BorderLayout() );
        add( comboBox );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Layer List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new LayerList() );
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}