@Override protected Void call() {
    updateMessage("Sorting...");
    list.sort(null);
    updateMessage("Sorting complete.");
    updateProgress(1, 1); // jumps progress from indeterminate to 100%
    return null;
}