class JEditorPaneDropTarget extends DropTargetAdapter{

    JEditorPaneDropTarget(JEditorPane pane) {
        new DropTarget(pane, this);
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        Transferable tr = dtde.getTransferable();
        Object data;
        try {
            DataFlavor df = new DataFlavor("text/plain; class=java.lang.String");
            data = tr.getTransferData(df);
            JEditorPane pane = (JEditorPane) ((DropTarget)dtde.getSource()).getComponent();
            pane.setText((String)data);
        } catch (Exception e) {
            //
        }
    }
}