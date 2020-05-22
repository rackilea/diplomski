private static boolean dragging = false;
private static int     start    = -1;
private static int     end      = -1;

public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    List<String> input = IntStream.range(1, 100)
                                  .mapToObj(String::valueOf)
                                  .collect(Collectors.toList());

    final TableViewer viewer = new TableViewer(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
    viewer.setContentProvider(ArrayContentProvider.getInstance());
    viewer.setLabelProvider(new ColumnLabelProvider());
    viewer.setInput(input);

    Table table = viewer.getTable();
    // Stop dragging when the mouse is released
    table.addListener(SWT.MouseUp, e -> dragging = false);
    // Start dragging when the mouse is clicked
    table.addListener(SWT.MouseDown, e -> {
        dragging = true;
        start = -1;
        end = -1;
    });
    // Listen to mouse movement
    table.addListener(SWT.MouseMove, e -> {
        // If we're currently dragging
        if (dragging)
        {
            // Get the item under the mouse pointer
            TableItem item = table.getItem(new Point(e.x, e.y));

            if(item != null)
            {
                int current = table.indexOf(item);

                // If this is the first selected item, remember the position
                if (start == -1 && end == -1)
                {
                    start = current;
                    end = current;
                }
                // Else, just remember the "end" of the drag
                else
                    end = current;

                // Tell the viewer to select the items
                viewer.setSelection(new StructuredSelection(input.subList(Math.min(start, end), Math.max(start, end))));

                // Now, we actually move the table when the drag movement reaches the top or bottom
                int tableHeight = table.getClientArea().height;
                int itemHeight = table.getItemHeight();

                if (e.y < itemHeight && current > 0)
                    table.showItem(table.getItem(current - 1));
                else if (e.y > tableHeight - itemHeight && current < table.getItemCount() - 1)
                    table.showItem(table.getItem(current + 1));
            }
        }
    });

    shell.pack();
    shell.open();
    shell.setSize(400, 300);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}