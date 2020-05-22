private void showComponents(List<String> users, Object[][] object) {

    lbl = new JLabel[users.size()];
    tbl = new JTable[users.size()];
    dtm = new DefaultTableModel[users.size()];
    sp = new JScrollPane[users.size()];

    for (int i = 0; i < users.size(); i++) {
        //Label
        lbl[i] = new JLabel(users.get(i));

        //Data
        dtm[i] = new DefaultTableModel(0, 2);
        for (int j = 0; j < object.length; j++) {
            Object[] data = object[j];
            dtm[i].addRow(data);
        }

        //Table
        tbl[i] = new JTable(dtm[i]);

        //Pane
        sp[i] = new JScrollPane(tbl[i]);
        sp[i].setBackground(Color.red);

        //Add components to panel
        jPanel2.add(lbl[i]);
        jPanel2.add(sp[i]);
    }

    setVisible(true);
}