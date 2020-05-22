// Translate file change action into watch event
private WatchEvent.Kind<?> translateActionToEvent(int action)
{
    switch (action) {
        case FILE_ACTION_MODIFIED :
            return StandardWatchEventKinds.ENTRY_MODIFY;

        case FILE_ACTION_ADDED :
        case FILE_ACTION_RENAMED_NEW_NAME :
            return StandardWatchEventKinds.ENTRY_CREATE;

        case FILE_ACTION_REMOVED :
        case FILE_ACTION_RENAMED_OLD_NAME :
            return StandardWatchEventKinds.ENTRY_DELETE;

        default :
            return null;  // action not recognized
    }
}