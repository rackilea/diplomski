Grid grid = new Grid(){
    @Override
    protected void doCancelEditor() {
        super.doCancelEditor();
        setEditorEnabled(false); // disable the editor every time when editing is completed
    }
};

grid.setEditorEnabled(false); // by default the editor is disabled

....
// grid initialization
....

// create any component (button for example) which will call the editor
Button button = new Button("Edit");
button.addClickListener((Button.ClickListener) event -> {
    grid.setEditorEnabled(true); // activate the editor when the desired event occurred
    grid.editItem(itemId); // call the editor with itemId (it may be selected itemId)
});