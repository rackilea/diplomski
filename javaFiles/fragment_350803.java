private JPanel createCenterFrame() {
    JPanel pnl = new JPanel();
    Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    Color lineColor = new Color(224, 224, 224);
    Border lineBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, lineColor);
    Border loweredBevel = BorderFactory.createLoweredBevelBorder();
    Border compoundSetup = BorderFactory.createCompoundBorder(raisedBevel, lineBorder);
    Border compoundFinal = BorderFactory.createCompoundBorder(compoundSetup, loweredBevel);
    TitledBorder topFrameTitle = BorderFactory.createTitledBorder(compoundFinal, "Stuff");
    topFrameTitle.setTitleJustification(TitledBorder.CENTER);

    pnl.setBorder(topFrameTitle);
    pnl.setLayout(new BorderLayout());

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);

    JTextArea ta = new JTextArea();
    ta.setOpaque(false);
    ta.setText("This is an example of a transparent text area inside a transparent scroll pane, but you could just as easily wrap a transparent panel into it and get the same result");
    ta.setWrapStyleWord(true);
    ta.setLineWrap(true);

    scrollPane.setViewportView(ta);

    pnl.add(scrollPane);

    pnl.setOpaque(false);
    return pnl;
}