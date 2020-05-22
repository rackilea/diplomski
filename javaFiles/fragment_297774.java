public ClockFrame(){
    int frameWidth = 1000;
    int frameHeight = 1000;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(frameWidth, frameHeight));
    setLayout(new BorderLayout());

    JLayeredPane pane = new JLayeredPane();
    pane.setOpaque(true);
    pane.setBackground(Color.BLACK);
    add(pane);

    SecondHand sHand=new SecondHand("sechand.png");
    MinuteHand mHand=new MinuteHand("minhand.png");

    mHand.setBounds(0, 0, frameWidth, frameHeight);
    sHand.setBounds(0, 0, frameWidth, frameHeight);

    pane.add(mHand, 1);
    pane.add(sHand, 2);

    pack();
    setResizable(false);
    setVisible(true);
}