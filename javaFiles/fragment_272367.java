public class MyDragSourceListener implements DragSourceListener {
private final Viewer dragSourceViewer;
private final boolean multiObjectsEnabled;
private final Class<?> transferrableElementClass;
private Object[] draggedObjects;

public MyDragSourceListener(Viewer dragSourceViewer, boolean multiObjectsEnabled, Class<?> transferrableElementClass) {
    this.dragSourceViewer = dragSourceViewer;
    this.multiObjectsEnabled = multiObjectsEnabled;
    this.transferrableElementClass = transferrableElementClass;
}

@Override
public void dragStart(DragSourceEvent event) {
    Control source = ((DragSource) event.getSource()).getControl();

    draggedObjects = null;

    if (dragSourceViewer.getControl().equals(source)) {
        if (multiObjectsEnabled) {
            draggedObjects = ((StructuredSelection) dragSourceViewer.getSelection()).toArray();
        } else {
            draggedObjects = new Object[]{((StructuredSelection) dragSourceViewer.getSelection()).getFirstElement()};
        }
    }
    event.doit = draggedObjects.length > 0 && transferredDataIsSupported();
}

private boolean transferredDataIsSupported() {
    boolean ret = true;
    for (Object o : draggedObjects) {
        if (o == null || !transferrableElementClass.isAssignableFrom(o.getClass())) {
            ret = false;
            break;
        }
    }
    return ret;
}

@Override
public void dragSetData(DragSourceEvent event) {
    event.data = Arrays.asList(draggedObjects);
}

@Override
public void dragFinished(DragSourceEvent event) {
    if (event.detail != DND.DROP_NONE) {
        dragSourceViewer.refresh();
    }
    draggedObjects = null;
}
}