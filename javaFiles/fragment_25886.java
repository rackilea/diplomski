public WindowTemplate()
{
    super("My first window");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // "this" is optional
    setVisible(true);
    setSize(550, 450);
    setLocationRelativeTo(null);
}