import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.text.*;
import java.io.*;

public class DragComponent extends JPanel
{
//  public final static DataFlavor COMPONENT_FLAVOR = new DataFlavor(Component[].class, "Component Array");
    public static DataFlavor COMPONENT_FLAVOR;

    public DragComponent()
    {
        try
        {
            COMPONENT_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" + Component[].class.getName() + "\"");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        setLayout(null);
        setTransferHandler( new PanelHandler() );

        MouseListener listener = new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                JComponent c = (JComponent) e.getSource();
                TransferHandler handler = c.getTransferHandler();
                handler.exportAsDrag(c, e, TransferHandler.MOVE);
            }
        };

        TransferHandler handler = new ComponentHandler();

        for (int i = 0; i < 5; i++)
        {
            JLabel label = new JLabel("Label " + i);
            label.setSize( label.getPreferredSize() );
            label.setLocation(30 * (i+1), 30 * (i+1));
            label.addMouseListener( listener );
            label.setTransferHandler( handler );
            add( label );
        }
    }

    private static void createAndShowUI()
    {
        DragComponent north = new DragComponent();
        north.setBackground(Color.RED);
        north.setPreferredSize( new Dimension(200, 200) );

        DragComponent south = new DragComponent();
        south.setBackground(Color.YELLOW);
        south.setPreferredSize( new Dimension(200, 200) );

        JFrame frame = new JFrame("DragComponent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}

class ComponentHandler extends TransferHandler
{
    @Override
    public int getSourceActions(JComponent c)
    {
        return MOVE;
    }

    @Override
    public Transferable createTransferable(final JComponent c)
    {
        return new Transferable()
        {
            @Override
            public Object getTransferData(DataFlavor flavor)
            {
                Component[] components = new Component[1];
                components[0] = c;
                return components;
            }

            @Override
            public DataFlavor[] getTransferDataFlavors()
            {
                DataFlavor[] flavors = new DataFlavor[1];
                flavors[0] = DragComponent.COMPONENT_FLAVOR;
                return flavors;
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor)
            {
                return flavor.equals(DragComponent.COMPONENT_FLAVOR);
            }
        };
    }

    @Override
    public void exportDone(JComponent c, Transferable t, int action)
    {
        System.out.println(c.getBounds());
    }
}

class PanelHandler extends TransferHandler
{
    @Override
    public boolean canImport(TransferSupport support)
    {
        if (!support.isDrop())
        {
            return false;
        }

        boolean canImport = support.isDataFlavorSupported(DragComponent.COMPONENT_FLAVOR);
        return canImport;
    }

    @Override
    public boolean importData(TransferSupport support)
    {
        if (!canImport(support))
        {
            return false;
        }

        Component[] components;

        try
        {
            components = (Component[])support.getTransferable().getTransferData(DragComponent.COMPONENT_FLAVOR);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        Component component = components[0];
        Container container = (Container)support.getComponent();
        container.add(component);
//      container.revalidate();
//      container.repaint();
        container.getParent().revalidate();
        container.getParent().repaint();

        JLabel label = (JLabel)component;
        DropLocation location = support.getDropLocation();
        System.out.println(label.getText() + " + " + location.getDropPoint());
        label.setLocation( location.getDropPoint() );
        return true;
    }
}