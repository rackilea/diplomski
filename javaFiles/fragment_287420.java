for (ILink l : links) {
    IItemHandle linkHandle = (IItemHandle) l.getTargetRef().resolve();
    if (linkHandle instanceof IWorkItemHandle) {
        IWorkItem aWorkItem = (IWorkItem) teamRepository.itemManager().fetchCompleteItem(linkHandle, IItemManager.DEFAULT, monitor);
    }
}