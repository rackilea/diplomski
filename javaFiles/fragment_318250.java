private void createRightSide(Composite mainComposite) {
    ScrolledComposite detailsSC = new ScrolledComposite(mainComposite, SWT.SMOOTH | SWT.BORDER | SWT.V_SCROLL);
    GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
    detailsSC.setLayoutData(gd);
    detailsSC.setLayout(new GridLayout(1, true));
    detailsSC.setExpandHorizontal(true);
    detailsSC.setExpandVertical(true);

    Composite detailsComposite = new Composite(detailsSC, SWT.NONE);
    detailsComposite.setLayout(new GridLayout(2, false));
    GridData gdd = new GridData(SWT.FILL, SWT.FILL, true, true);
    detailsComposite.setLayoutData(gdd);

    Label dmyLabel = new Label(detailsComposite, SWT.NONE);
    GridData labelData = new GridData();
    dmyLabel.setLayoutData(labelData);
    dmyLabel.setText("Dummy");

    detailsSC.setContent(detailsComposite);       
    detailsSC.setMinSize(detailsComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));