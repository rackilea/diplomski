public class CustomComponent extends JPanel
{
    private JLabel heading = new JLabel(...);
    private JTextField textField = new JTextField(5);
    private JLabel error = new JLabel(...);

    public CustomComponent()
    {
        add( heading );
        add( textField );
        add( error );

        clearProperties( heading );
        clearProperties( textField );
        clearProperties( error );

    }

    private void clearProperties(JComponent component)
    {
        component.setForeground( null );
        component.setFont( null );
    }
}