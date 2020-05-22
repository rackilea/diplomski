public class TestPane extends JPanel {

    private Rectangle previousBounds;

    public TestPane() {

        JButton unmax = new JButton("Switch");
        unmax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.windowForComponent(TestPane.this);
                frame.dispose();
                if (frame.getExtendedState() != JFrame.NORMAL) {
                    frame.setExtendedState(JFrame.NORMAL);
                    frame.setUndecorated(false);
                    frame.setBounds(previousBounds);
                } else {
                    previousBounds = frame.getBounds();
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setUndecorated(true);
                }
                frame.setVisible(true);
            }
        });
        setLayout(new GridBagLayout());
        add(unmax);

    }

}