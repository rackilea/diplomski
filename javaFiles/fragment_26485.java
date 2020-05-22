public Game()
{
 this.ConstructFrame();
 Dimension size = new Dimension(width * scale, height * scale);
 setPreferredSize(size);
}

private void ConstructFrame()
{
    this.frame = new JFrame();
    this.frame.setResizable(true);
    this.frame.setTitle("Frytree");
    this.frame.add(game);
    this.frame.pack();
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.setLocationRelativeTo(null);
    this.frame.setVisible(true);
}