private static List<Label>  labels  = new ArrayList<Label>();
private static List<Color>  colors  = new ArrayList<Color>();

public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new RowLayout(SWT.VERTICAL));

    colors.add(display.getSystemColor(SWT.COLOR_BLUE));
    colors.add(display.getSystemColor(SWT.COLOR_CYAN));
    colors.add(display.getSystemColor(SWT.COLOR_GREEN));
    colors.add(display.getSystemColor(SWT.COLOR_YELLOW));
    colors.add(display.getSystemColor(SWT.COLOR_RED));

    for (int i = 0; i < 5; i++)
    {
        Label label = new Label(shell, SWT.BORDER);
        label.setText("Button " + i);
        label.setBackground(colors.get(i));

        labels.add(label);
    }

    Button sortButton = new Button(shell, SWT.TOGGLE);
    sortButton.setText("Sort");

    sortButton.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            Button source = (Button) e.widget;

            final boolean asc = source.getSelection();

            Label oldFirst = labels.get(0);

            Collections.sort(labels, new Comparator<Label>()
            {
                @Override
                public int compare(Label o1, Label o2)
                {
                    int result = o1.getText().compareTo(o2.getText());

                    if (asc)
                        result = -result;

                    return result;
                }
            });

            Label label = labels.get(0);
            label.moveAbove(oldFirst);

            for (int i = 1; i < labels.size(); i++)
            {
                labels.get(i).moveBelow(labels.get(i - 1));
            }
            shell.layout();
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}