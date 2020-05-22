...
functionToDelete.delete(forceDeletion, progressMonitor);

ITranslationUnit tu = functionToDelete.getTranslationUnit();
if (tu.isWorkingCopy()) {
    boolean forceCommit = true;
    ((IWorkingCopy) tu).commit(forceCommit, progressMonitor);
}