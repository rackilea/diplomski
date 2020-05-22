public class ColourMouseAdapter extends MouseAdapter
{
    private final Color colour;
    private final JButton button;
    public ColourMouseAdapter(JButton button, Color colour)
    {
        this.colour = colour;
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
         button.setForeground(colour);
    }
}
JButton jbutton = new JButton();
jButton.addMouseListener(new ColourMouseAdapter(jbutton, Color.WHITE));