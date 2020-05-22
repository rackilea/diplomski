public class TableShellExample {

  Display d;

  Shell s;

  TableShellExample() {

    d = new Display();
    s = new Shell(d);

    s.setSize(250, 200);

    s.setText("A Table Shell Example");
    s.setLayout(new FillLayout());

    Table table = new Table(s, SWT.MULTI | SWT.FULL_SELECTION);

    TableColumn tc1 = new TableColumn(table, SWT.CENTER);
    TableColumn tc2 = new TableColumn(table, SWT.CENTER);
    TableColumn tc3 = new TableColumn(table, SWT.CENTER);
    tc1.setText("First Name");
    tc2.setText("Last Name");
    tc3.setText("Address");
    tc1.setWidth(70);
    tc2.setWidth(70);
    tc3.setWidth(80);
    table.setHeaderVisible(true);

    TableItem item1 = new TableItem(table, SWT.NONE);
    item1.setText(new String[] { "Tim", "Hatton", "Kentucky" });
    TableItem item2 = new TableItem(table, SWT.NONE);
    item2.setText(new String[] { "Caitlyn", "Warner", "Ohio" });
    TableItem item3 = new TableItem(table, SWT.NONE);
    item3.setText(new String[] { "Reese", "Miller", "Ohio" });
    TableItem item4 = new TableItem(table, SWT.NONE);
    item4.setText(new String[] { "Rey", "Miller", "Texas" });
    TableItem item5 = new TableItem(table, SWT.NONE);
    item5.setText(new String[] { "Json", "Miller", "Alabama" });

    if((table.getStyle() & SWT.MULTI ) != 0 && (table.getStyle() & SWT.FULL_SELECTION ) != 0)
    table.addListener(SWT.DragDetect, e -> {

      TableItem item = table.getItem(new Point(e.x, e.y));
      int startIndex = -1;
      int endIndex = -1;
      if (item != null) {
        startIndex = table.indexOf(item);
        Tracker tracker = new Tracker(table.getParent(), SWT.RESIZE);
        tracker.setStippled(true);
        tracker.setRectangles(new Rectangle[] { new Rectangle(e.x,e.y,1,1) });
        if (tracker.open()) {
          TableItem finishedItem = table.getItem(table.toControl(Display.getDefault().getCursorLocation()));
          if (finishedItem != null) {
            endIndex = table.indexOf(finishedItem);
          }
        }
        tracker.dispose();
        table.deselectAll();
        if (startIndex != -1 && endIndex != -1) {
          table.setSelection(Math.min(startIndex, endIndex), Math.max(startIndex, endIndex));
        }
      }

    });

    s.open();
    while (!s.isDisposed()) {
      if (!d.readAndDispatch())
        d.sleep();
    }
    d.dispose();
  }

  public static void main(String[] argv) {

    new TableShellExample();
  }
}