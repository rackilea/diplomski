for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
                SVNLogEntry logEntry = (SVNLogEntry) entries.next();

                if (logEntry.getChangedPaths().size() > 0) {
                    Set<String> changedPathsSet = logEntry.getChangedPaths().keySet();

                    for (Iterator<String> changedPaths = changedPathsSet.iterator(); changedPaths
                            .hasNext();) {
                        SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry
                                .getChangedPaths().get(changedPaths.next());
                        String path = entryPath.getPath();
                        if (!path.startsWith(updatePath)) {
                            continue;
                        }