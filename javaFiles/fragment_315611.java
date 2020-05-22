// Tabs
tabbedPane.add("List", PList);
tabbedPane.add("Chart", PChart);
add(tabbedPane);
studentTable.createTable(); // Create the table
PList.add(studentTable);
validate(); // Revalidate the frame