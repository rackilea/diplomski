textFieldSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) JLISTNAME.getModel();
                for (int i = 0; i < 10; ++i) {
                    model.add(i, "blah");
                }
            }
        });