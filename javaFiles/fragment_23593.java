final JTextField textField = new JTextField(50);
DragGestureListener dragListener = new DragGestureListener() {
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        // how the drag cursor should look like
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

        // the component being dragged
        JTextField tf = (JTextField) dge.getComponent();

        // Here a Transferable is created directly for a single file name
        dge.startDrag(cursor, new TransferableFile(tf.getText()));
    }
};

final DragSource ds = new DragSource();
ds.createDefaultDragGestureRecognizer(textField, DnDConstants.ACTION_COPY, dragListener);