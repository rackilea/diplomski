public class MyDropAdapter<TM extends ITask> extends ViewerDropAdapter {

private final Class<TM> targetModelClass;
private List<TM> listOfModels;

protected MyDropAdapter(Viewer viewer, Class<TM> targetModelClass, List<TM> listOfModels) {
    super(viewer);
    this.listOfModels = listOfModels;
    this.targetModelClass = targetModelClass;
}

@Override
public boolean performDrop(Object arg0) {
    boolean ret = false;
    TM targetModel = targetModelClass.cast(determineTarget(getCurrentEvent()));

    if (targetModel != null) {
        if (List.class.isAssignableFrom(arg0.getClass())) {
            ret = processDropToTable(targetModel, arg0);
            getViewer().refresh();
        }
    }
    return ret;
}

public final boolean processDropToTable(TM targetModel, Object data) {

    List<TM> transferredModels = (List<TM>) data;
    List<TM> copyOfTransferredModels = transferredModels;

    switch (getCurrentOperation()) {
    case DND.DROP_COPY:
        copyOfTransferredModels = deepCopyBeanList(transferredModels, new String[]{});
        break;
    case DND.DROP_MOVE:
        // moving
        break;
    default:
        throw new UnsupportedOperationException(getCurrentOperation() + " is not supported!");
    }
    adjustPosition(transferredModels, copyOfTransferredModels, targetModel);

    return true;
}

private void adjustPosition(List<TM> transferredModels, List<TM> copyOfTransferredModels, TM targetModel) {
    int transferredObjectPosition = listOfModels.indexOf(transferredModels.get(0));
    listOfModels.removeAll(copyOfTransferredModels);
    addModelsToNewLocation(copyOfTransferredModels, targetModel, listOfModels, transferredObjectPosition);
    for (int i = 0; i < listOfModels.size(); i++) {
        int orderPosition = i * 10 + 10;
        listOfModels.get(i).setOrder(orderPosition);
    }
}

protected void addModelsToNewLocation(List<TM> transferredModels, TM targetModel, List<TM> targetList, int transferredObjectPosition) {
    switch (determineLocation(getCurrentEvent())) {
    case LOCATION_AFTER:
    case LOCATION_ON:
        int i;
        if (!transferredModels.contains(targetModel)) {
            i = targetList.indexOf(targetModel) + 1;
        } else {
            i = transferredObjectPosition;
        }
        targetList.addAll(i, transferredModels);
        break;
    case LOCATION_BEFORE:
        if (!transferredModels.contains(targetModel)) {
            i = targetList.indexOf(targetModel);
        } else {
            i = transferredObjectPosition;
        }
        targetList.addAll(i, transferredModels);

        break;
    case LOCATION_NONE:
    default:
        break;
    }
}

private List<TM> deepCopyBeanList(List<TM> transferredModels, String[] ignoreProperties) {
    List<TM> targetList = new LinkedList<TM>();

    for (TM element : transferredModels) {
        try {
            @SuppressWarnings("unchecked")
            TM copy = (TM) element.getClass().newInstance();
            BeanUtils.copyProperties(element, copy, ignoreProperties);
            targetList.add(copy);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    return targetList;
}

@Override
public boolean validateDrop(Object arg0, int arg1, TransferData arg2) {
    boolean ret = false;
    for (Transfer t : new Transfer[]{TaskTransfer.INSTANCE}) {
        if (t.isSupportedType(arg2)) {
            ret = true;
            break;
        }
    }
    return ret;
}
}