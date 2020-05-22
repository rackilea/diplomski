JFrame f = new JFrame("ComboWorkerTest");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(new GridLayout(0, 1));
final JComboBox jcb = new JComboBox(new Integer[]{value});
f.add(new JButton(new AbstractAction("Add") {
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) jcb.getModel();
        model.addElement(++value);
    }
}));
f.add(jcb);
f.pack();
f.setLocationRelativeTo(null);
f.setVisible(true);