private static void setButtonColors(
    JSpinner spinner, Color foreground, Color background)
{
    int n = spinner.getComponentCount();
    for (int i=0; i<n; i++)
    {
        Component c = spinner.getComponent(i);
        if (c instanceof JButton)
        {
            c.setForeground(foreground); // Has no effect
            c.setBackground(background);
        }
    }
}