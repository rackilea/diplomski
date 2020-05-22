import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TitledBorderListener extends MouseAdapter
{
    private JPopupMenu editPopup;
    private JTextField editTextField;
    private TitledBorder titledBorder;

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getClickCount != 2)
            return;

        //  Edit the border on a double click

        JComponent component = (JComponent)e.getSource();
        Border border = component.getBorder();

        if (border instanceof TitledBorder)
        {
            titledBorder = (TitledBorder)border;
            FontMetrics fm = component.getFontMetrics( titledBorder.getTitleFont() );
            int titleWidth = fm.stringWidth(titledBorder.getTitle()) + 20;
            Rectangle bounds = new Rectangle(0, 0, titleWidth, fm.getHeight());

            if (bounds.contains(e.getPoint()))
            {
                if (editPopup == null)
                    createEditPopup();

                //  Position the popup editor over top of the title

                editTextField.setText( titledBorder.getTitle() );
                Dimension d = editTextField.getPreferredSize();
                d.width = titleWidth;
                editPopup.setPreferredSize(d);
                editPopup.show(component, 0, 0);

                editTextField.selectAll();
                editTextField.requestFocusInWindow();
            }
        }
    }

    private void createEditPopup()
    {
        editTextField = new JTextField();

        //  Add an Action to the text field to save the new title text

        editTextField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String value = editTextField.getText();
                titledBorder.setTitle( value );
                editPopup.setVisible(false);
                editPopup.getInvoker().revalidate();
                editPopup.getInvoker().repaint();
            }
        });

        //  Add the editor to the popup

        editPopup = new JPopupMenu();
        editPopup.setBorder( new EmptyBorder(0, 0, 0, 0) );
        editPopup.add(editTextField);
    }

    private static void createAndShowUI()
    {

        JPanel panel = new JPanel();
        panel.setBorder( new TitledBorder("Double Click to Edit") );
        panel.addMouseListener( new TitledBorderListener() );

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setSize(200, 200);
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