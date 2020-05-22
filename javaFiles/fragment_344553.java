import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display 
    extends JFrame
{ 
    Box upperBox   = new Box(BoxLayout.X_AXIS);
    Box dynamicBox = new Box(BoxLayout.Y_AXIS);
    Box staticBox  = new Box(BoxLayout.X_AXIS);

    public Display()
    {
        super("Test");
        setTitle("Test");
        setSize(800,800);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents()
    {
        //This will be the parent panel for other panels.
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        upperBox.add(new JLabel("Resource"));
        upperBox.add(new JComboBox<>(new String[] { "option1", "option2", "option3",}));
        upperBox.add(new JLabel("Something"));

        panel.add(upperBox);

        staticBox.add(new JButton(new AddResourceAction("Add new")));

        panel.add(dynamicBox); //just add this box now, it will be filled later with components
        panel.add(staticBox);  

        add(panel); 
    }

    class AddResourceAction extends AbstractAction 
    {
        public AddResourceAction(String n)
        {
            super(n);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Box box = new Box(BoxLayout.X_AXIS);
            box.add(new JLabel("Resource"));
            box.add(new JComboBox<>(
                        new String[] { "option1", "option2", "option3",}));
            box.add(new JLabel("Something"));

            dynamicBox.add(box);

            revalidate(); 
        }
    }

    public static void main(String[] args) 
    {
        /*display panel*/
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override 
            public void run() 
            {
                new Display().setVisible(true);
            }
        });
    }
}