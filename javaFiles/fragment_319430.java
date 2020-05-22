Object[] columnNames = {"Name", "Starts", "Ends"};
DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
        for (Advertisement adv : advertisements) {
            Object[] o = new Object[3];
            o[0] = adv.getName();
            o[1] = adv.getPublication_starts();
            o[2] = adv.getPublication_ends();
            model.addRow(o);
        }
        advertisementList_JT.setModel(model);