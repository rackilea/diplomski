DefaultTableModel dm = new DefaultTableModel(0, 0);
    String header[] = new String[] { "Status", "Task Title", "Start",
            "Pause", "Stop", "Statulses" };
    dm.setColumnIdentifiers(header);
    tblTaskList.setModel(dm);

    for (int count = 1; count <= 10; count++) {
        Vector<Object> data = new Vector<Object>();
        data.add(count);
        data.add("Project Title" + count);
        data.add("Start");
        data.add("Stop");
        data.add("Pause");
        data.add("Status");
        System.out.println("test :- " + count);
        dm.addRow(data);
    }