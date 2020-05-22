protected AtomicReference<PersistentState> persistentState = new AtomicReference<PersistentState>(PersistentState.UNKNOWN);

public final PersistentState getPersistentState() {
    return this.persistentState.get();
}

protected void setPersistentState(final PersistentState newPersistentState) {
    persistentState.set(newPersistentState);
    notifyPersistentStateChanged();
}

private void notifyPersistentStateChanged() {
}