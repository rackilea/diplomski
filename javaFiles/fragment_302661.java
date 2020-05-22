public class CButton extends JButton
{
    public CButton(String text, Icon icon)
    {
        super(text, icon);
    }

    @Override
    public JToolTip createToolTip()
    {
        JToolTip toolTip = super.createToolTip();
        toolTip.setForeground(Color.BLACK);
        toolTip.setBackground(Color.WHITE);
        toolTip.setFont(new Font("Arial", Font.PLAIN, 12));
        return toolTip;
    }
};