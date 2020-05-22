JTable table = new JTable(buildTableModel(rs));
//JFrame frame = new JFrame("Reports");         <--- take this out
//frame.setSize(800, 700);                      <--- don't set size, just pack
setTitle("Reports");                            <--- set title
add(new JScrollPane(table));                    <--- add to scrollpane
pack();                                         <--- pack
setVisible(true);                               <--- set visible