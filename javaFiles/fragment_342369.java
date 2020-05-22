private void courseUnit() {
            String[] units = {"6", "5", "4", "3", "2", "1"};
            int x = 520, y = 30;
            for (int i = 0; i < 10; i++) {
                comboUnits = new JComboBox<>(units);
                comboUnits.setBounds(x, y, 100, 25);
                y += 30;
                comboUnits.setToolTipText("Select course unit");
                comboUnits.setVisible(true);
                //comboUnits.addActionListener(new PaneAction());
                add(comboUnits);

//////////////// Here are the changes

                comboUnits.addActionListener (new ActionListener () {
                   public void actionPerformed(ActionEvent e) {
                      String selectedItem = (String)e.getSelectedItem();
                   }
                });
                comboList.add(comboUnits); //comboUnits added to ArrayList
            }
        }