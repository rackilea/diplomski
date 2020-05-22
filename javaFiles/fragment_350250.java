public class Test extends JFrame
{
    public static void main(String[] args) {
        Test frame = new Test();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttons = new JPanel(new BorderLayout());
        frame.add(buttons, BorderLayout.WEST);
        JButton blackButton = new JButton("Black");
        buttons.add(blackButton, BorderLayout.NORTH);
        JButton whiteButton = new JButton("White");
        buttons.add(whiteButton, BorderLayout.SOUTH);
        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(200, 0));
        frame.add(content, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

        JPanel blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                content.add(blackPanel);
                content.revalidate();
                content.repaint();
            }
        });
        whiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.removeAll();
                content.add(whitePanel);
                content.revalidate();
                content.repaint();
            }
        });
    }
}