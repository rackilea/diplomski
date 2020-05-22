public class BadLayout08 {

    public static void main(String[] args) {
        new BadLayout08();
    }

    public BadLayout08() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new IMView();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class IMView extends JFrame {

        JButton selectIMGFolder = new JButton("Select Folder");
        JPanel originalImage;
//Labels and sliders to control image
        JLabel brightnessLabel = new JLabel("Brightness");
        JSlider brightness = new JSlider(-255, 255, 0);
        JLabel contrastLabel = new JLabel("Contrast");
        JSlider contrastSlider = new JSlider(-255, 255, 0);
        JLabel random = new JLabel("Random Test Label");

        public IMView() {
            super("Image manipulation");

            JPanel mainJPanel = new JPanel();
            mainJPanel.setLayout(new GridBagLayout());

            GridBagConstraints gc = new GridBagConstraints();

            originalImage = new JPanel();
            originalImage.setPreferredSize(new Dimension(400, 300));
            originalImage.setBackground(Color.RED);
            //first column

            gc.anchor = GridBagConstraints.LINE_START;

            gc.gridx = 0;
            gc.gridy = 0;
            mainJPanel.add(selectIMGFolder, gc);

            gc = new GridBagConstraints();
            gc.anchor = GridBagConstraints.LINE_START;
            gc.gridx = 0;
            gc.gridy = 1;
            mainJPanel.add(originalImage, gc);

            gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 2;
            mainJPanel.add(random, gc);

            //second column
            //brightness

            JPanel sidePane = new JPanel(new GridBagLayout());
            gc = new GridBagConstraints();

            gc.gridx = 1;
            gc.gridy = 0;

            sidePane.add(brightnessLabel, gc);

            gc.gridx = 1;
            gc.gridy = 1;
            sidePane.add(brightness, gc);

            gc.gridx = 1;
            gc.gridy = 2;
            sidePane.add(contrastLabel, gc);

            gc.weighty = 10;
            gc.anchor = GridBagConstraints.FIRST_LINE_START;
            gc.gridx = 1;
            gc.gridy = 3;
            sidePane.add(contrastSlider, gc);

            gc = new GridBagConstraints();
            gc.gridx = 1;
            gc.gridy = 1;
            gc.gridheight = GridBagConstraints.REMAINDER;
            gc.anchor = GridBagConstraints.NORTH;
            mainJPanel.add(sidePane, gc);

            this.add(mainJPanel);
            this.setVisible(true);
            this.setPreferredSize(new Dimension(800, 600));
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
//other code
    }
}