/**
 * map inotify event to WatchEvent.Kind
 */
private WatchEvent.Kind<?> maskToEventKind(int mask) {
    if ((mask & IN_MODIFY) > 0)
        return StandardWatchEventKinds.ENTRY_MODIFY;
    if ((mask & IN_ATTRIB) > 0)
        return StandardWatchEventKinds.ENTRY_MODIFY;
    if ((mask & IN_CREATE) > 0)
        return StandardWatchEventKinds.ENTRY_CREATE;
    if ((mask & IN_MOVED_TO) > 0)
        return StandardWatchEventKinds.ENTRY_CREATE;
    if ((mask & IN_DELETE) > 0)
        return StandardWatchEventKinds.ENTRY_DELETE;
    if ((mask & IN_MOVED_FROM) > 0)
        return StandardWatchEventKinds.ENTRY_DELETE;
    return null;
}