public class MyMasterDetailsBlock extends MasterDetailsBlock{

    private SectionPart fMasterSectionPart;
    private Section fMasterSection;
    private TreeViewer fTreeViewer;

    [...]

     /**
     * Create contents of the master details block.
     * @param managedForm
     * @param parent
     */
    @Override
    protected void createMasterPart(IManagedForm managedForm, Composite parent) {
        fMasterSection = managedForm.getToolkit().createSection(parent,
                   ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
        fMasterSectionPart = new SectionPart(fMasterSection, 0);

        Composite composite = new Composite(fMasterSection, SWT.RIGHT);
        fTreeViewer = new TreeViewer(composite, SWT.FILL);
        fTreeViewer.setContentProvider(new MyContentProvider());
        fTreeViewer.setLabelProvider(new MyLabelProvider());
        fTreeViewer.setInput(fMyInput);

        fTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                detailsPart.selectionChanged(fMasterSectionPart,
                                             event.getSelection());
           }
       );

       [...]
}

     /**
     * Register the pages.
     * @param part
     */
    @Override
    protected void registerPages(DetailsPart part) {
        part.registerPage(MyClass.class, new MyClassDetailsPage());
    }
    [...]
}