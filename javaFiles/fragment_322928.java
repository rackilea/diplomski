public class ListEmpty extends JFrame {

    JComboBox<String> changingCB = new JComboBox<>();
    JComboBox<String> unchangingCB = new JComboBox<>();

    String[] numbers = new String[] {"1", "2", "3"};
    String[] letters = new String[] {"a", "b", "c"};
    String[] symbols = new String[] {"!", "@", "#"};

    ListEmpty() {

        unchangingCB.addItem("Numbers");
        unchangingCB.addItem("Letters");
        unchangingCB.addItem("Symbols");
        unchangingCB.addActionListener(new SheepTypeListHandler());

        getContentPane().add(unchangingCB, BorderLayout.LINE_START);
        getContentPane().add(changingCB, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private class SheepTypeListHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            changingCB.removeAllItems(); // Compare with removing this line.
            if (unchangingCB.getSelectedItem().equals("Numbers")) {
                for (String item : numbers)
                    changingCB.addItem(item);
            } else if (unchangingCB.getSelectedItem().equals("Letters")) {
                for (String item : letters)
                    changingCB.addItem(item);
            } else if (unchangingCB.getSelectedItem().equals("Symbols")) {
                for (String item : symbols)
                    changingCB.addItem(item);
            }
        }
    }

    public static void main(String[] args) {

        new ListEmpty();
    }
}