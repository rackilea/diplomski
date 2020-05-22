public void reset()
{
    Component[] component = board.getComponents();

    // Reset user interface
    for(int i=0; i<component.length; i++)
    {
        if (component[i] instanceof JButton)
        {
            JButton button = (JButton)component[i];
            button.setEnabled(true);
            button.setText("");
        }

    }
}