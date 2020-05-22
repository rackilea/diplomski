private void createTable(Composite tableComposite, Text selectProjectPathText){
        //Create the tableViewer and it´s columns
        projectCompositeViewer = new ProjectConfigViewer(tableComposite, selectProjectPathText,SWT.SINGLE | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);

        //Create an input to display
        List<ProjectDirectory> b = new ArrayList<ProjectDirectory>();
        b.add(new ProjectDirectory("AA", "FF"));
        b.add(new ProjectDirectory("BB", "CC"));

        Project pro = new Project("A", "B", 2, b);
        projectCompositeViewer.setInput(pro);
    }