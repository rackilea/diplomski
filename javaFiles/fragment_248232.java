class MyFileChooser extends JFileChooser {
public MyFileChooser() {
    JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[]{"text", "binary"}));

    JPanel panel1 = (JPanel) this.getComponent(2);
      JPanel panel2 = (JPanel) panel1.getComponent(2);

      Component c1=panel2.getComponent(0);
      Component c2=panel2.getComponent(1);
      Component c3=panel2.getComponent(2);
      Component c4=panel2.getComponent(3);
      Component c5=panel2.getComponent(4);

      JPanel comboboxPanel = new JPanel();
      comboboxPanel.setLayout(new FlowLayout());
      comboboxPanel.add(new JLabel("Document Name: "));
      comboboxPanel.add(comboBox);

      panel2.removeAll();
      panel2.add(comboboxPanel);
      panel2.add(Box.createRigidArea(new Dimension(5,5)));
      panel2.add(c1);
      panel2.add(c2);
      panel2.add(c3);
      panel2.add(c4);
      panel2.add(c5);
}