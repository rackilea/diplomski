JFrame frame = new JFrame("Combo Box Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setLayout(new FlowLayout());

    Vector comboBoxItems=new Vector();
    comboBoxItems.add("A");
    comboBoxItems.add("B");
    comboBoxItems.add("C");
    comboBoxItems.add("D");
    comboBoxItems.add("E");
    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
    JComboBox comboBox = new JComboBox(model);
    frame.add(comboBox);

    JButton button = new JButton("Add new element in combo box");
    frame.add(button);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            model.addElement("F");
        }
    });

    frame.setVisible(true);