class ButtonObject extends JButton
{
    public ButtonObject(String text, int x, int y, int width, int height)
    {
        super(text);
        this.setBounds(x, y, width, height);
    }
}