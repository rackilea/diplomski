/**
 * Create contents of the window.
 */
protected void createContents() {
    shlWhois = new Shell();
    shlWhois.setSize(450, 300);
    shlWhois.setText("Whois");
    shlWhois.setLayout(new GridLayout(2, false));

    Label lblDomain = new Label(shlWhois, SWT.NONE);
    lblDomain.setLayoutData(GridDataFactory.fillDefaults().create());
    lblDomain.setText("Domain");

    text = new Text(shlWhois, SWT.BORDER);
    text.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

    final StyledText styledText = new StyledText(shlWhois, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI | SWT.WRAP);
    styledText.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());

    Button btnWhois = new Button(shlWhois, SWT.NONE);
    btnWhois.setText("Search");
}