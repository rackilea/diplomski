public class ColourMouseAdapter extends MouseAdapter
{
    private final Color colour;
    public ColourMouseAdapter(Color colour)
    {
        this.colour = colour;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
         if(e.getSource() instanceof JButton)
         {
              JButton button = e.getSource();
              button.setForeground(colour);
         }
    }
}