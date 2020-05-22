public void initWindow(String title, JComponent component)
{
    JFrame jf = new JFrame(title);
    Toolkit kit = this.getToolkit();
    int width = (int) kit.getScreenSize().getWidth();
    int height = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight();
    jf.setPreferredSize(new Dimension(width, height));
    // ...
}