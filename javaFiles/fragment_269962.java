public class Buttons {

    JButton[] buttons = new JButton[4];
    JButton move = new JButton("Move");

    private final String text = "O";

    Buttons() {
        JPanel panel = new JPanel();
        for (int i = 0; i < buttons.length; i++)
            panel.add(buttons[i] = new JButton());
        buttons[2].setText(text);

        move.addActionListener(new ActionListener() {

            private int ballpos = 2;
            private int dir = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[ballpos].setText(null);
                ballpos += dir;
                buttons[ballpos].setText(text);
                if (ballpos == buttons.length - 1)
                    dir = -1;
                else if (ballpos == 0)
                    dir = 1;
            }
        });

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.add(move, BorderLayout.PAGE_START);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Buttons());
    }
}