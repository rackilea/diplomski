private Component buildGrid() {

        Grid<Branch> branchGrid = new Grid<>();
        branchGrid.setItems(DummyData.allBranches);
        branchGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        branchGrid.setSizeFull();
        branchGrid.getEditor().setEnabled(false);

        branchGrid.addComponentColumn((ValueProvider<Branch, Component>) branch -> {
            Button btnEdit = new Button(VaadinIcons.EDIT);
            btnEdit.addStyleName(MaterialTheme.BUTTON_CUSTOM + " " + MaterialTheme.BUTTON_BORDER);
            btnEdit.setDescription("Click for edit!");
            return btnEdit;
        }).setId("edit");

        branchGrid.addColumn(b -> b.getBranchId()).setCaption("Branch Id");
        branchGrid.addColumn(b -> b.getBranchName()).setCaption("Branch Name");
        branchGrid.addColumn(b -> b.getEmail()).setCaption("E-Mail");
        branchGrid.addColumn(b -> b.getPhone()).setCaption("Phone");
        branchGrid.addColumn(b -> b.getLocation()).setCaption("Location");
        branchGrid.addColumn(b -> String.valueOf(b.getOwner().getUsername())).setCaption("Owner");
        branchGrid.addColumn(b -> b.isActive()).setCaption("Active Status");

        return branchGrid;
    }