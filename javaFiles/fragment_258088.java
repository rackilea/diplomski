public class BadLabel extends JFrame {
    // start attributes

    private JPanel jPanel1 = new JPanel(new BorderLayout(), true);
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    // end attributes

    public BadLabel(String title) {
        // Frame-Init
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
//        setResizable(false);
        Container cp = getContentPane();
//        cp.setLayout(null);
        // start components

//        jPanel1.setBounds(48, 24, 209, 145);
        jPanel1.setOpaque(true);
        jPanel1.setBackground(Color.RED);
        cp.add(jPanel1);

        JPanel buttons = new JPanel();
//        jButton1.setBounds(88, 208, 75, 25);
        jButton1.setText("jButton1");
        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1_ActionPerformed(evt);
            }
        });
        buttons.add(jButton1);
//        jButton2.setBounds(184, 208, 75, 25);
        jButton2.setText("jButton2");
        jButton2.setMargin(new Insets(2, 2, 2, 2));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2_ActionPerformed(evt);
            }
        });
        buttons.add(jButton2);
        // end components

        cp.add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    } // end of public BadLabel

    // start methods
    public void jButton1_ActionPerformed(ActionEvent evt) {
        BufferedImage image = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = image.createGraphics();
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setColor(Color.BLUE);
        g.drawLine(0, 0, 300, 400);
        g.dispose();
        JLabel l = new JLabel(new ImageIcon(image));
        l.setBorder(new LineBorder(Color.BLUE));
        jPanel1.add(l);
        jPanel1.revalidate();
    } // end of jButton1_ActionPerformed

    public void jButton2_ActionPerformed(ActionEvent evt) {
        // TODO add your code here
    } // end of jButton2_ActionPerformed

    // end methods
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception exp) {
                }
                new BadLabel("BadLabel");
            }
        });
    } // end of main
} // end of class BadLabel}