private Composite createPluginPathCreatedComposite(){

        .................................

        //Label of bigger composite
        Text selectProjectPathText = new Text(pluginPathCreatedComposite, SWT.BORDER);
        selectProjectPathText.setEnabled(false);
        FormData selectProjectPathTextData = new FormData();
        selectProjectPathTextData.top = new FormAttachment(selectProjectPathLabel, 0, SWT.CENTER);
        selectProjectPathTextData.left = new FormAttachment(selectProjectPathLabel, 5,SWT.RIGHT);
        selectProjectPathTextData.right = new FormAttachment(100,-55);
        selectProjectPathText.setLayoutData(selectProjectPathTextData); 

        //Button to select a system directory
        Button selectProjectPathButton = new Button(pluginPathCreatedComposite, SWT.NONE);
        selectProjectPathButton.setText("Browse");
        FormData selectProjectPathButtonData = new FormData();
        selectProjectPathButtonData.top = new FormAttachment(selectProjectPathText, 0, SWT.TOP);
        selectProjectPathButtonData.left = new FormAttachment(selectProjectPathText, 5, SWT.RIGHT);
        selectProjectPathButtonData.right = new FormAttachment(100,-5);
        selectProjectPathButton.setLayoutData(selectProjectPathButtonData); 
        selectProjectPathButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell());
                dialog.setFilterPath(""); // Windows specific
                selectProjectPathText.setText(dialog.open());
            }
        });

        //Create a composite for the table inside a bigger composite pluginPathCreatedComposite
        Composite tableComposite = new Composite(pluginPathCreatedComposite, SWT.NONE);
        FormData tableCompositeData = new FormData();
        tableCompositeData.left = new FormAttachment(selectProjectPathLabel, 0, SWT.LEFT);
        tableCompositeData.top = new FormAttachment(selectProjectPathLabel, 40, SWT.TOP);
        tableCompositeData.right = new FormAttachment(selectProjectPathButton,-10,SWT.LEFT);
        tableCompositeData.bottom = new FormAttachment(createProjectConfigButton,-10,SWT.TOP);
        tableComposite.setLayoutData(tableCompositeData);

        //Function to create the table. 
        createTable(tableComposite,selectProjectPathText);

        //add row to the tableviewer
        addRow.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ProjectDirectory directory = new ProjectDirectory("Insert variable", "Click to add path");
                projectCompositeViewer.add(directory);
            }
        });

        //deleterow from the tableviewer
        Button deleteRow = new Button(pluginPathCreatedComposite, SWT.NONE);
        FormData deleteRowData = new FormData();
        deleteRowData.top = new FormAttachment(addRow,5,SWT.BOTTOM);
        deleteRowData.left = new FormAttachment(selectProjectPathButton,0,SWT.LEFT);
        deleteRowData.right = new FormAttachment(selectProjectPathButton,0,SWT.RIGHT);
        deleteRow.setLayoutData(deleteRowData);
        deleteRow.setText("Delete");

        deleteRow.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ISelection selection = projectCompositeViewer.getSelection();
                if (selection instanceof IStructuredSelection) {
                    Iterator iterator = ((IStructuredSelection) selection).iterator();
                    while (iterator.hasNext()) {
                        Object obj = iterator.next();
                        projectCompositeViewer.remove(obj);
                    }
                }
            }
        });
        }