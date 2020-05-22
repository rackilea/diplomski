YourClass.get(int i) {
    if (!entryExists(i)) {
        lockEntry(i);
        entry = createEntry(i);
        putEntryInCache(i, entry);
        unlockEntry(i);
    }
    return entry;
}