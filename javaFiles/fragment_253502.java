public class HangPane extends JPanel {

    private JLabel lblImage;
    private JButton btnAction;
    private int guess = 0;

    public HangPane() {

        setLayout(new BorderLayout());
        lblImage = new JLabel();
        lblImage.setPreferredSize(new Dimension(46, 172));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        lblImage.setVerticalAlignment(JLabel.CENTER);
        btnAction = new JButton("Guess");

        String imageName = "HG0.png";
        lblImage.setIcon(new ImageIcon(imageName));


        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String imageName = "HG0.png";

                guess++;
                switch (guess) {
                    case 1:
                        imageName = "HG1.png";
                        break;
                    case 2:
                        imageName = "HG2.png";
                        break;
                    case 3:
                        imageName = "HG3.png";
                        break;
                    case 4:
                        imageName = "HG4.png";
                        break;
                    case 5:
                        imageName = "HG5.png";
                        break;
                    case 6:
                        imageName = "HG6.png";
                        break;
                    default:
                        guess = 0;
                        break;
                }

                lblImage.setIcon(new ImageIcon(imageName));

            }
        });

        add(lblImage, BorderLayout.CENTER);
        add(btnAction, BorderLayout.SOUTH);

    }
}