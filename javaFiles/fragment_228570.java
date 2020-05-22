public class CardExample extends JFrame {

    CardExample() {

        JPanel main = new JPanel(new BorderLayout());
        CardLayout cl = new CardLayout();
        main.setLayout(cl);
        for (int i = 0; i < 4; i++)
            main.add(new StepPanel(i));

        JButton next = new JButton("Next");
        next.addActionListener(e -> cl.next(main));

        add(main);
        add(next, BorderLayout.PAGE_END);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    class StepPanel extends JPanel {

        StepPanel(int i){

            add(new JLabel("Step " + i));
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new CardExample());
    }
}