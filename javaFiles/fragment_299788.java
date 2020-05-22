JPanel panel1 = new JPanel();
    add(panel1);

    JTextField field1 = new JTextField("field1");
    field1.setName("field1");
    panel1.add(field1);

    JTextField field2 = new JTextField("field2");
    field2.setName("field2");
    panel1.add(field2);

    Component[] components = panel1.getComponents();
    if (null != components) {
        for (Component component : components) {
            if (component instanceof JTextField) {
                System.out.println(((JTextField)component).getText());
            }
        }
    }