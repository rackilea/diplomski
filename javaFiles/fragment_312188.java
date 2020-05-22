public class TestOptionPane03 {

    public static void main(String[] args) {
        new TestOptionPane03();
    }

    public TestOptionPane03() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JPanel panel = new JPanel();
                panel.add(new JLabel("Please make a selection:"));
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                model.addElement("Chocolate");
                model.addElement("Strewberry");
                model.addElement("Vanilla");
                JComboBox comboBox = new JComboBox(model);
                panel.add(comboBox);

                int result = JOptionPane.showConfirmDialog(null, panel, "Flavor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (result) {
                    case JOptionPane.OK_OPTION:
                        System.out.println("You selected " + comboBox.getSelectedItem());
                        break;
                }

            }
        });
    }
}