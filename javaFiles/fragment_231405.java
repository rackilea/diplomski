private void createManyFrames() {
    final JFrame mainFrame = new JFrame("Stack Overflow: closing frames");
    mainFrame.setBounds(100, 100, 240, 600);
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.getContentPane().setLayout(new FlowLayout());
    final List<JFrame> frames = initializeFrames(Arrays.asList("one", "two", "three"));
    for (final JFrame frame : frames) {
        final JButton button = new JButton(frame.getTitle());
        mainFrame.getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.dispose();
                frames.remove(frame);
            }
        });
        frame.setVisible(true);
    }
    mainFrame.setVisible(true);
}

private List<JFrame> initializeFrames(final List<String> frameNames) {
    final List<JFrame> frames = new ArrayList<JFrame>();
    for (final String frameName : frameNames) {
        final JFrame frame = new JFrame(frameName);
        frame.setBounds(480, 120 * (1 + frames.size()), 200, 100);
        final JPanel panel = new JPanel();
        panel.add(new JLabel("Label in panel in frame " + frameName + "."));
        frame.getContentPane().add(panel);
        frames.add(frame);
    }
    return frames;
}