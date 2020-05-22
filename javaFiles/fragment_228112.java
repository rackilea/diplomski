public void createControl(Composite parent)
{
    //
    // create the composite to hold the widgets
    //
    this.composite = new Composite(parent, SWT.NONE);

    //
    // create the desired layout for this wizard page
    //
    GridLayout layout = new GridLayout();
    layout.numColumns = 4;
    this.composite.setLayout(layout);

    // set the composite as the control for this page
    setControl(this.composite);
}

void onEnterPage()
{
    final MacroModel model = ((MacroWizard) getWizard()).model;
    String selectedKey = model.selectedKey;
    String[] attrs = (String[]) model.macroMap.get(selectedKey);

    for (int i = 0; i < attrs.length; i++)
    {
        String attr = attrs[i];
        Label label = new Label(this.composite, SWT.NONE);
        label.setText(attr + ":");

        new Text(this.composite, SWT.NONE);
    }
    pack();
}