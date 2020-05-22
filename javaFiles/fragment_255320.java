public Trail() {
    setTitle("Attendence Manager");
    setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(new Dimension(dim.width - 20, dim.height - 100));
    c = getContentPane();
    gbl = new GridBagLayout();
    setLayout(gbl);

    try {
        final BufferedImage image = ImageIO.read(new File("images/sample.jpg"));
        banner = new JLabel(){
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        c.add(banner, gbc);
    }
    catch (IOException ex) {
        Logger.getLogger(Trail.class.getName()).log(Level.SEVERE, null, ex);
    }

    this.setVisible(true);
    addWindowListener(new MyWindowAdapter());
}