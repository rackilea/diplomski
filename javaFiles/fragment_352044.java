public class Screen {

    ListGrid grid1 = new ListGrid();
    TextItem text1 = new TextItem("text1", "Text 1");

    public void initialize() {
        // normally its not required to create subclasses of ListGrid/Button/Window/etc.
        // unless a significant change in their behavior is needed

        ListGrid grid2 = new ListGrid();
        // setup grid properties
        // set grid fields

        TextItem text2 = new TextItem("text2", "Text 2");

        final ListGrid grid3 = new ListGrid();
        final TextItem text3 = new TextItem("text3", "Text 3");

        IButton button = new IButton("Edit");
        button.addClickHandler(new ClickHandler() { // this is declaring an anonymous inner class
            public void onClick(ClickEvent clickEvent) { // this method is a member of that anonymous inner class
                // out of three ListGrid and thee TextItem instances, only following can be accessed in this method/class
                //   grid1, text1 (these are not local variables, inner class can access outer class members without any issue)
                //   grid3, text3 (as they are final, even though local variables)
            }
        });

        // that does not mean, grid2 and text2 can not be used, they can be, just not inside an anonymous inner class
        // e.g.-
        DynamicForm form = new DynamicForm();
        form.setFields(text2);

        VLayout layout = new VLayout();
        layout.addMember(grid2);
    }
}