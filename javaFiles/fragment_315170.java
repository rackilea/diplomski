//first instance
JMenuBar taskMenuBar = new MyJMenuBarImplementation();
JPanel panelMyTask = new JPanel();
frame.getContentPane().add(panelMySoftware, "name_xxx");
panelMyTask.add(taskMenuBar);

//second instance
JMenuBar softwareMenuBar = new MyJMenuBarImplementation();
JPanel panelMySoftware = new JPanel();
frame.getContentPane().add(panelMySoftware, "name_yyy");
panelMySoftware.add(softwareMenuBar);

//and so on...