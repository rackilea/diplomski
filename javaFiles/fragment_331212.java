table.changeSelection(0, 0, false, false);

if (table.editCellAt(0, 0))
{
    Component editor = table.getEditorComponent();
    editor.requestFocusInWindow();
    //((JTextComponent)editor).selectAll();
}