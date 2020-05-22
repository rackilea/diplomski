public class Draw extends JPanel
{
    private String[] params

    public Draw(String params)
    {
        this.params = params;
        this.setSize(800,800);  // this generally should be avoided
        JPanel drawing = new JPanel();
        this.add(drawing);
        this.setVisible(true);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // this should be out of the if block
        if (params != null && params.length > 0 && params[0].equals("Image1")) {
          // ..... etc