public JPanel fundo() {
    JPanel bg = new JPanel(new BorderLayout());
    try {
        Image backgroundImage = ImageIO.read(new File("C:/ceu.png"));
        setContentPane(new JPanel(new BorderLayout()) {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, null);
            }
        });
    } catch (IOException e) {
        System.out.println(e);
    }
    return bg;
}