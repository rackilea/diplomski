public class EntryPointClass implements EntryPoint {
    public void onModuleLoad() {
        ApplicationScreen screen = new ApplicationScreen();

        HStack drawArea = new HStack();
        drawArea.setWidth100();
        drawArea.setHeight100();
        drawArea.addMember(screen.getComponents());
        drawArea.draw();
    }
}

public class ApplicationScreen { // this class does not need to extend from a widget
    public Canvas getComponents() {
        // a method that prepares the interface
        // using a from+grid type layout, without a popup window

        ListGrid grid = getListGrid();

        DynamicForm form = getDynamicForm(grid); // have to pass grid in order to add/update records on button events

        VLayout layout = new VLayout();
        layout.addMember(form);
        layout.addMember(grid);

        return layout;
    }

    private DynamicForm getDynamicForm(final ListGrid grid) { // have to declare grid as final to access from event handler inner classes
        final TextItem text1 = new TextItem("text1", "Text 1");  // have to declare as final for same reason

        ButtonItem saveButton = new ButtonItem("Save");
        saveButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                // use text1, grid and other components to save form values and refresh grid
            }
        });

        // creating and configuring form
        DynamicForm form = new DynamicForm();
        form.setWidth100();
        form.setFields(text1, saveButton);

        return form;
    }

    private ListGrid getListGrid() {
        // preparing grid fields
        ListGridField field1 = new ListGridField("field1", "Field 1");

        // creating and configuring grid
        ListGrid grid = new ListGrid(); // not final, does not need to be
        grid.setWidth100();
        grid.setFields(field1);

        return grid;
    }
}