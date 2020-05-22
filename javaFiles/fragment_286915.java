public class Example extends JPanel{

    private static BufferedImage scaledImg;

    public static void main(String[] args) {
        Example e = new Example();
        JFrame f = new JFrame();
        f.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        f.add(e,c);

        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        JButton b = new JButton("save");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                File outputfile = new File("c:\\image.png");
                try {
                    ImageIO.write(scaledImg, "png", outputfile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        f.add(b,c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        Graphics2D g = (Graphics2D) arg0;
        BufferedImage img = null;
        try {
            img = ImageIO.read( Example.class.getResource("/res/3_disc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scaledImg = Scalr.resize(img,getSize().height,getSize().width,new BufferedImageOp[]{});
        g.drawImage (scaledImg, null, 0, 0);
    }

}