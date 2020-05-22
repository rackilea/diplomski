List<LogEntry> entries = ..
try (ObjectOutputStream out = new ObjectOutputStream(....)) {
    out.writeObject(currentTerm);
    out.writeObject(votedeFor);
    out.writeObject(entries);
}