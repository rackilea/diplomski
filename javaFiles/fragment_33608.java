public class ColorListener implements ActionListener
{
    private Color background;

    public ButtonListener(Color background)
    {
        this.background = background;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)evt.getSource();
        Component parent = button.getParent();
        parent.setBackground( background );   
    }
}