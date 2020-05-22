public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);

    WizardDialog wizardDialog = new WizardDialog(shell, new MyWizard());
    wizardDialog.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static class MyWizard extends Wizard
{
    protected MyWizardPage one;

    public MyWizard()
    {
        super();
    }

    @Override
    public void addPages() {
        one = new MyWizardPage("Page One");
        addPage(one);
    }

    @Override
    public boolean performFinish() {
        return false;
    }

}

private static class MyWizardPage extends WizardPage
{
    protected MyWizardPage(String pageName) {
        super(pageName);
    }

    @Override
    public void createControl(Composite comp)
    {
        Composite container = new Composite(comp, SWT.NULL);
        GridLayout layout = new GridLayout(2, true);
        container.setLayout(layout);

        final TableViewer viewer = new TableViewer(container, SWT.READ_ONLY);

        // First column is for the name
        TableViewerColumn col = createTableViewerColumn("Name", 100, 0, viewer);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                if(element instanceof Person)
                {
                    return ((Person)element).getName();
                }
                return "";
            }
        });

        // First column is for the location
        TableViewerColumn col2 = createTableViewerColumn("Location", 100, 1, viewer);
        col2.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                if(element instanceof Person)
                {
                    return ((Person)element).getLocation();
                }
                return "";
            }
        });

        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.horizontalSpan = 2;
        table.setLayoutData(data);

        /* Add listener to listen for selection change */
        final Text name = new Text(container, SWT.BORDER);
        name.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
        final Text location = new Text(container, SWT.BORDER);
        location.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));

        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent arg0) {
                IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
                Person person = (Person) selection.getFirstElement();

                name.setText(person.getName());
                location.setText(person.getLocation());
            }
        });

        viewer.setContentProvider(ArrayContentProvider.getInstance());

        final Person[] persons = new Person[] { new Person("Baz", "Loc"),
                new Person("BazBaz", "LocLoc"), new Person("BazBazBaz", "LocLocLoc") };

        viewer.setInput(persons);

        setControl(container);
        setPageComplete(false);
    }
}

private static TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber, TableViewer viewer) {
    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
    final TableColumn column = viewerColumn.getColumn();
    column.setText(title);
    column.setWidth(bound);
    column.setResizable(true);
    column.setMoveable(false);

    return viewerColumn;
}

public static class Person {
    private String name;
    private String location;

    public Person(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString()
    {
        return name + " " + location;
    }
}