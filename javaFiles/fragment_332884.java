class Editor { ... }
class NavBar implements ActionListener
{
    public NavBar(Editor editor)
    {
        myEditor = editor;
    }
    public void actionPerformed (ActionEvent e)
    {
        // call methods of myEditor
    }

    private Editor myEditor;
}

Editor theEditor = new Editor();
NavBar theNavBar = new NavBar(theEditor);