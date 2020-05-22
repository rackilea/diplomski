JButton buttonSave = new JButton("Save");
    buttonSave.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }

            for (Person p : table.getAllPersons()) {
                System.out.println(p.getName() + " --> " + p.getPerson().getName());
            }
        }
    });