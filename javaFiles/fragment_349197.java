private static List<LogEntry> filterLog(LogEntries entries) {
    List<LogEntry> logs = new ArrayList<>();
    for (LogEntry entry : entries) {
        if(entry.getLevel().toString().equals(INFO)) {
            logs.add(entry);
        }
    }
    return logs;
}