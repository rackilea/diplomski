public class TestFrame extends JFrame {

    public TestFrame() {
        setLayout(new GridLayout());
        setSize(500, 500);

        JCheckBox checkboxOne = new JCheckBox("One");
        JCheckBox checkboxTwo = new JCheckBox("Two");
        JCheckBox checkboxThree = new JCheckBox("Three");

        final ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

        add(checkboxOne);
        add(checkboxTwo);
        add(checkboxThree);

        checkBoxes.add(checkboxOne);
        checkBoxes.add(checkboxTwo);
        checkBoxes.add(checkboxThree);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox checkbox = (JCheckBox) event.getSource();
                int index = checkBoxes.indexOf(checkbox) + 1;
                System.out.println("Checkbox #" + index + " is clicked");
            }
        };
        checkboxOne.addActionListener(actionListener);
        checkboxTwo.addActionListener(actionListener);
        checkboxThree.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        TestFrame frame = new TestFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}