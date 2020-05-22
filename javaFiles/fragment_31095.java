//ui = new JPanel(new GridBagLayout());
int[] columns = new int[22];
Arrays.fill(columns, 30);
GridBagLayout gbl = new GridBagLayout();
gbl.columnWidths = columns;
ui = new JPanel(gbl);