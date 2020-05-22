GridBagLayout layout;
public void initGUI() {
    /*...*/
    con.setLayout(layout = new GridBagLayout());
    layout.columnWidths = new int[9];
    Arrays.fill(layout.columnWidths, 50);
    layout.rowHeights = new int[9];
    Arrays.fill(layout.rowHeights, 50);