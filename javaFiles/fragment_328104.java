BufferedImage stopPicture = null;
    try {
        stopPicture = ImageIO.read(new File("stop.png"));
    } catch (IOException ex) { }
    JLabel picLabel = new JLabel(new ImageIcon( stopPicture ));
    JButton btnStop = new JButton("");
    btnStop.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SerialTest.getInstance().stopMoving();
        }
    });
    btnStop.add(picLabel);