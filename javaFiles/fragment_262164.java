public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    final DateTime first = new DateTime(shell, SWT.CALENDAR);
    final DateTime second = new DateTime(shell, SWT.CALENDAR);

    first.addListener(SWT.Selection, new Listener()
    {
        private Calendar cal = Calendar.getInstance();

        @Override
        public void handleEvent(Event arg0)
        {
            cal.set(Calendar.YEAR, first.getYear());
            cal.set(Calendar.MONTH, first.getMonth());
            cal.set(Calendar.DAY_OF_MONTH, first.getDay());

            cal.add(Calendar.DAY_OF_YEAR, 2);

            second.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}