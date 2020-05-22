public Comp_Animal_Notes(Composite parent, int style, Animal a)
        throws Exception {
    super(parent, SWT.NONE);
    setLayout(new FillLayout(SWT.HORIZONTAL));
    ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    scrolledComposite.setExpandHorizontal(true);
    scrolledComposite.setExpandVertical(true);

    Composite composite = new Composite(scrolledComposite, SWT.NONE);
    composite.setLayout(new GridLayout(2, false));

    ArrayList<Note> alNotes = a.getAnimalNotes();
    this.setRedraw(false);
    for (int i = 0; i < alNotes.size(); i++) {
        Note note = alNotes.get(i);

        CLabel lblNoteDate = new CLabel(composite, SWT.BORDER);
        lblNoteDate.setFont(SWTResourceManager.getFont("Tahoma", 8,
                SWT.BOLD));
        lblNoteDate.setText("Date:");
        lblNoteDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        CLabel lblNotedatetxt = new CLabel(composite, SWT.BORDER);
        lblNotedatetxt.setBackground(SWTResourceManager
                .getColor(SWT.COLOR_WHITE));
        lblNotedatetxt.setText(note.getUserDate());
        lblNotedatetxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        CLabel lblNoteTxt = new CLabel(composite, SWT.BORDER);
        lblNoteTxt.setBackground(SWTResourceManager
                .getColor(SWT.COLOR_WHITE));
        lblNoteTxt.setText(note.getStrNote());
        lblNoteTxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
    }

    scrolledComposite.setContent(composite);
    scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    this.setRedraw(true);
}