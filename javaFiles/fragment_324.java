// This was good
JScrollPane scrollpane = new JScrollPane(table);
// Then you changed it
scrollpane.setViewportView(tabbedPane);
// Then you added it to the tabbed pane
tabbedPane.addTab("Process",null,table,"");