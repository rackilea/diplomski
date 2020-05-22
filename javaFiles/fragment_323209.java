import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.reflect.*;

public class SwingComponentInfo
{
    private String name;
    private ArrayList<Class> types = new ArrayList<Class>();
    private ArrayList<Object> values = new ArrayList<Object>();

    public SwingComponentInfo(String name)
    {
        this.name = name;
    }

    public SwingComponentInfo(String name, Class type, Object value)
    {
        this.name = name;
        addParameter(type, value);
    }

    public void addParameter(Class type, Object value)
    {
        types.add(type);
        values.add(value);
    }

    public String getName()
    {
        return name;
    }

    public JComponent createComponent()
    {
        try
        {
            String classname = "javax.swing.J" + name;
            Class<?> type = Class.forName(classname);
            Constructor constructor = type.getConstructor( types.toArray( new Class[types.size()] ) );
            JComponent component = (JComponent)constructor.newInstance( values.toArray() );

            return component;
        }
        catch(Exception e) { e.printStackTrace(); }

        return null;
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SwingComponent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout( new FlowLayout() );
        SwingComponentInfo button = new SwingComponentInfo("Button", String.class, "New Button");
        frame.add(button.createComponent());

        SwingComponentInfo textField = new SwingComponentInfo("TextField", int.class, 10);
        frame.add(textField.createComponent());

        SwingComponentInfo textArea = new SwingComponentInfo("TextArea", int.class, 5);
        textArea.addParameter(int.class, 30);
        frame.add(textArea.createComponent());

        frame.setLocationByPlatform( true );
        frame.pack();
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