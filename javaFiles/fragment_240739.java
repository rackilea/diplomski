@Override
public void splitEditor(float ratio, int where, IEditorPart containerEditor, IEditorPart editorToInsert) {
    MPart container = containerEditor.getSite().getService(MPart.class);
    if (container == null) {
        return;
    }
    MPart toInsert = editorToInsert.getSite().getService(MPart.class);
    if (toInsert == null) {
        return;
    }

    insertEditor(ratio, where, container, toInsert);
}

/**
 * Inserts the editor into the container editor.
 *
 * @param ratio the ratio
 * @param where where to insert ({@link EModelService#LEFT_OF}, {@link EModelService#RIGHT_OF}, {@link EModelService#ABOVE} or
 * {@link EModelService#BELOW})
 * @param containerEditor the container editor
 * @param editorToInsert the editor to insert
 */
public void insertEditor(float ratio, int where, MPart containerEditor, MPart editorToInsert) {
    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    EModelService service = window.getService(EModelService.class);
    MPartStack toInsert = getPartStack(editorToInsert);

    MArea area = getArea(containerEditor);
    MPartSashContainerElement relToElement = area.getChildren().get(0);
    service.insert(toInsert, relToElement, where, ratio);
}

@SuppressWarnings("restriction")
private MPartStack getPartStack(MPart childPart) {
    MStackElement stackElement = childPart;
    MPartStack newStack = org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl.eINSTANCE.createPartStack();
    newStack.getChildren().add(stackElement);
    newStack.setSelectedElement(stackElement);
    return newStack;
}

private MArea getArea(MPart containerPart) {
    MUIElement targetParent = containerPart.getParent();
    while (!(targetParent instanceof MArea)) {
        targetParent = targetParent.getParent();
    }
    MArea area = (MArea) targetParent;
    return area;
}