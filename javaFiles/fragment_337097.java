class SaveAction extends AbstractAction
{
    private GraphEditor graphEditor;
    private boolean myBoolean;

    public SaveAction(GraphEditor graphEditor, boolean myBoolean)
    {
        this.myBoolean = myBoolean;
        this.graphEditor = graphEditor;
    }

        public void actionPerformed(ActionEvent e) {

            this.graphEditor....
            .. do whatever 
        }
}