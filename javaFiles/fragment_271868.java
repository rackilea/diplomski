public class ImageDarkener extends JFrame {
    private JButton button;
    private JLabel myImage;

    public ImageDarkener() {
        createImageDarkener();
    }

    private void createImageDarkener() {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        contentPane.setSize(900, 600);

        myImage = new JLabel();
        myImage.setIcon(new ImageIcon("myImage.png"));
        myImage.setBounds(403, 31, 200, 200);
        contentPane.add(myImage);

        button = new JButton("Go darker");
        button.setBounds(90, 400, 100, 100);
        contentPane.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buttonActionPerformed(event);
            }
        });

        setTitle("Image gets darker");
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    private void buttonActionPerformed(ActionEvent event) {
        Image img = ((ImageIcon) myImage.getIcon()).getImage();

        BufferedImage buffered = new BufferedImage(img.getWidth(null),
        img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        buffered.getGraphics().drawImage(img, 0, 0, null);

        for (int i = 0; i < buffered.getWidth(); i++) {
            for (int j = 0; j < buffered.getHeight(); j++) {                    
                int rgb = buffered.getRGB(i, j);
                int alpha = (rgb >> 24) & 0x000000FF;
                Color c = new Color(rgb);
                if (alpha != 0) {
                    int red = (c.getRed() - 10) <= 0 ? 0 : c.getRed() - 10;
                    int green = (c.getGreen() - 10) <= 0 ? 0
                        : c.getGreen() - 10;
                    int blue = (c.getBlue() - 10) <= 0 ? 0 : c.getBlue() - 10;
                    c = new Color(red, green, blue);
                    buffered.setRGB(i, j, c.getRGB());
                }
            }
        }
        myImage.setIcon(new ImageIcon(buffered));
    }

    public static void main(String args[]) {
        ImageDarkener img = new ImageDarkener();
        img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}