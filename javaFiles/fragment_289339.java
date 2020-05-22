editMemberBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        int row = table.getSelectedRow();
                        // int column = table.getSelectedColumn();
                        id = (Object) table.getValueAt(row, 0);
                        index = (Integer) id;
                        JOptionPane.showMessageDialog(null, index);
                        EditMemberGUI editMemberGUI = new EditMemberGUI(ShowMembersGUI.this);
                        editMemberGUI.showGUI();
                }
        });