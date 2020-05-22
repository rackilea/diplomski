import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GetFocusForJTextField extends JFrame
{
JButton jb;
JFileChooser jf;

    public GetFocusForJTextField()
    {
        createAndShowGUI();
    }

    private void createAndShowGUI()
    {
        // For NimbusLookAndFeel, JTextField is not
        // the default focus owner in JFileChooser
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){}

        setTitle("Get Focus for JTextField");
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jb=new JButton("Open JFileChooser");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                showDialog();
            }
        });

        jf=new JFileChooser();

        // Even if you add some other JTextField
        // as accessory to JFileChooser
        jf.setAccessory(new JTextField(20));

        jf.addHierarchyListener(new HierarchyListener(){
            public void hierarchyChanged(HierarchyEvent he)
            {
                grabFocusForTextField(jf.getComponents());
            }
        });     

        add(jb);
    }

    // Loop to find the JTextField, the first
    // JTextField in JFileChooser
    // Even if you setAccessory which contains a JTextField
    // or which is JTextField itself, it will not get focus
    private void grabFocusForTextField(Component[] c)
    {
        for(Component k:c)
        {
            if(k instanceof JTextField)
            {
                JTextField jt=(JTextField)k;
                jt.grabFocus();
                break;
            }
            else if(k instanceof JPanel)
            {
                JPanel jp=(JPanel)k;
                grabFocusForTextField(jp.getComponents());
            }
        }
    }

    private void showDialog()
    {
        jf.showOpenDialog(this);
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new GetFocusForJTextField();
            }
        });
    }
}