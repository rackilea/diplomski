public class OverrideIconTransferHandler extends TransferHandler {
    private class MyDragGestureRecognizer extends DragGestureRecognizer {

        private static final long serialVersionUID = 1L;

        MyDragGestureRecognizer(DragGestureListener dgl) {
            super(DragSource.getDefaultDragSource(), null, NONE, dgl);
        }

        void gestured(JComponent c, MouseEvent e, int srcActions, int action) {
            setComponent(c);
            setSourceActions(srcActions);
            appendEvent(e);
            fireDragGestureRecognized(action, e.getPoint());
        }

        @Override
        protected void registerListeners() {
        }

        @Override
        protected void unregisterListeners() {
        }

    }

    private class MyDragHandler implements DragGestureListener, DragSourceListener {

        private boolean scrolls;

        @Override
        public void dragDropEnd(DragSourceDropEvent dsde) {
            DragSourceContext dsc = dsde.getDragSourceContext();
            JComponent c = (JComponent) dsc.getComponent();
            if (c.getTransferHandler() instanceof OverrideIconTransferHandler) {
                OverrideIconTransferHandler t = (OverrideIconTransferHandler) c.getTransferHandler();
                if (dsde.getDropSuccess()) {
                    t.exportDone(c, dsc.getTransferable(), dsde.getDropAction());
                } else {
                    t.exportDone(c, dsc.getTransferable(), NONE);
                }
            }
            c.setAutoscrolls(scrolls);
        }

        @Override
        public void dragEnter(DragSourceDragEvent dsde) {
        }

        @Override
        public void dragExit(DragSourceEvent dsde) {
        }

        @Override
        public void dragGestureRecognized(DragGestureEvent dge) {
            JComponent c = (JComponent) dge.getComponent();
            if (c.getTransferHandler() instanceof OverrideIconTransferHandler) {
                OverrideIconTransferHandler th = (OverrideIconTransferHandler) c.getTransferHandler();
                Transferable t = th.createTransferable(c);
                if (t != null) {
                    scrolls = c.getAutoscrolls();
                    c.setAutoscrolls(false);
                    try {
                        Image im = th.getDragImage();
                        if (im == null) {
                            dge.startDrag(null, t, this);
                        } else {
                            dge.startDrag(null, im, th.getDragImageOffset(), t, this);
                        }
                        return;
                    } catch (RuntimeException re) {
                        c.setAutoscrolls(scrolls);
                    }
                }

                th.exportDone(c, t, NONE);
            }
        }

        @Override
        public void dragOver(DragSourceDragEvent dsde) {
            if (dropCursorOverrides.containsKey(dsde.getDropAction())) {
                dsde.getDragSourceContext().setCursor(dropCursorOverrides.get(dsde.getDropAction()));
            } else {
                dsde.getDragSourceContext().setCursor(null);
            }
        }

        @Override
        public void dropActionChanged(DragSourceDragEvent dsde) {
        }
    }

    private static final long serialVersionUID = 1L;
    private MyDragGestureRecognizer myRecognizer = null;
    private final Map<Integer, Cursor> dropCursorOverrides = new HashMap<>();

    public void addDropCursorOverride(final int action, final Cursor cursor) throws IllegalArgumentException {
        if (!(action == COPY || action == MOVE || action == LINK || action == NONE)) {
            throw new IllegalArgumentException("Unknown Action Type");
        }
        dropCursorOverrides.put(action, cursor);
    }

    @Override
    public void exportAsDrag(JComponent comp, InputEvent e, int action) {
        if (comp.getTransferHandler() instanceof OverrideIconTransferHandler) {
            int srcActions = getSourceActions(comp);

            if (!(e instanceof MouseEvent) || !(action == COPY || action == MOVE || action == LINK) || (srcActions & action) == 0) {

                action = NONE;
            }

            if (action != NONE && !GraphicsEnvironment.isHeadless()) {
                if (myRecognizer == null) {
                    myRecognizer = new MyDragGestureRecognizer(new MyDragHandler());
                }
                myRecognizer.gestured(comp, (MouseEvent) e, srcActions, action);
            } else {
                exportDone(comp, null, NONE);
            }
        } else {
            super.exportAsDrag(comp, e, action);
        }
    }

    public void removeDropCursorOverride(final int action) throws IllegalArgumentException {
        if (!(action == COPY || action == MOVE || action == LINK || action == NONE)) {
            throw new IllegalArgumentException("Unknown Action Type");
        }
        dropCursorOverrides.remove(action);
    }
}