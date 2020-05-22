JFrame frame = new JFrame("Sort Records based on Time");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Object rows[][] = { { "1999/01/19 08:09:10 AM", "10:00:33 AM" },
    { "2000/01/12 05:00:56 PM", "07:12:19 AM" },
    { "2010/01/09 10:09:10 AM", "3:00:33 PM" } };

String columns[] = { "Date", "Time" };

TableModel model = new DefaultTableModel(rows, columns) {
    private static final long serialVersionUID = 1L;

    public Class<? extends Object> getColumnClass(int column) {
    return getValueAt(0, column).getClass();
    }
};

JTable table = new JTable(model);

TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
sorter.setComparator(0, new Comparator<String>() {
    public int compare(String record1, String record2) {
    if (record1 != null && record2 != null) {
        final DateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        try {
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        time1.setTime(sdf.parse(record1.substring(record1.indexOf(" "))));
        time1.setTimeZone(TimeZone.getTimeZone("MDT"));
        time2.setTime(sdf.parse(record2.substring(record2.indexOf(" "))));
        time2.setTimeZone(TimeZone.getTimeZone("MDT"));

        if (time1.before(time2)) {
            return -1;
        } else if (time1.after(time2)) {
            return 1;
        }
        } catch (ParseException e) {
        // Do Nothing
        }
    }
    return 0;
    }
});

table.setRowSorter(sorter);

JScrollPane pane = new JScrollPane(table);

frame.add(pane, BorderLayout.CENTER);

frame.setSize(300, 150);
frame.setVisible(true);