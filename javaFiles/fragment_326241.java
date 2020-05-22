public void run() {
    MatteBorderCO frame = new MatteBorderCO();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout()); 

    frame.add(createRToLPanel(50, 100, true));
    frame.add(createRToLPanel(100, 100, true));
    frame.add(createRToLPanel(100, 50, true));

    frame.setSize(600, 600);
    frame.setVisible(true);
}

private JPanel createRToLPanel(int leftInset, int rightInset, boolean matte) {
    JPanel outer = new JPanel();
    Border asymBorder = matte ? 
            BorderFactory.createMatteBorder(20, leftInset, 20, rightInset, Color.black) :
            BorderFactory.createEmptyBorder(20, leftInset, 20, rightInset)    ;
    outer.setBorder(BorderFactory.createCompoundBorder(
            asymBorder, BorderFactory.createLineBorder(Color.RED)
    ));

    JPanel inner = new JPanel();
    inner.setBackground(Color.YELLOW);
    inner.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    inner.add(new JLabel("RToL"));
    outer.add(inner);
    outer.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    return outer;
}