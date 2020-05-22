protected void setPersistentState(final PersistentState newPersistentState) {
    boolean changed = false;
    for (PersistentState oldState = getPersistentState();
            // Keep going if different
            changed = !oldState.equals(newPersistentState)
            // Transition old -> new successful?
            && !persistentState.compareAndSet(oldState, newPersistentState);
            // What is it now!
            oldState = getPersistentState()) {
        // Didn't transition - go around again.
    }
    if (changed) {
        // Notify the change.
        notifyPersistentStateChanged();
    }
}