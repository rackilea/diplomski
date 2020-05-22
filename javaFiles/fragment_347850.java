private TestGui() {
    add(createTopScrollPane(), BorderLayout.NORTH);
    add(createCenterScrollPane(), BorderLayout.CENTER);
    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    revalidate();
                    repaint();
                }
            });
        }
    });

    setSize(800,600);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

// another stuff

private JScrollPane createTopScrollPane(){
    JScrollPane scrollPane = new JScrollPane() {
        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            if (getHorizontalScrollBar() != null && getHorizontalScrollBar().isVisible()) {
                size.height += getHorizontalScrollBar().getHeight();
            }
            return size;
        }
    };
    Border raisedBevel = BorderFactory.createRaisedBevelBorder();
    Border lineBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(224,224,224));
    Border loweredBevel = BorderFactory.createLoweredBevelBorder();
    Border compoundSetup = BorderFactory.createCompoundBorder(raisedBevel, lineBorder);
    Border compoundFinal = BorderFactory.createCompoundBorder(compoundSetup, loweredBevel);

    //scrollPane.setPreferredSize(new Dimension(0, 160));
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    scrollPane.setBorder(compoundFinal);
    scrollPane.getViewport().setView(createTopFrame());
    return scrollPane;
}