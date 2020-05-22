public class OuterClass
    implements ActionListener
{
    public void actionPerformed(final ActionEvent e)
    {
        method();
    }

    // somewhere else in the code
    {
         component.addActionListener(this);
    }
}