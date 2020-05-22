ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Selected: " + optionsCombo.getSelectedItem());
        System.out.println(", Position: " + optionsCombo.getSelectedIndex());
      }
    };
    optionsCombo.addActionListener(actionListener);