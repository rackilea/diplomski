for (;;) {
    long freeSpace = getFreeSpace();
    if (freeSpace < 1000000) break;
    for (;;freeSpace > 0) {
        treeSet.add(readRecord());
        freeSpace -= MAX_RECORD_SIZE;
    }
}