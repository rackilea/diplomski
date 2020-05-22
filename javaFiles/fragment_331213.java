SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        table.changeSelection(0, 1, false, false);

        if (table.editCellAt(0, 1))
        {
            Component editor = table.getEditorComponent();
            editor.requestFocusInWindow();
            //((JTextComponent)editor).selectAll();
        }
    }
});