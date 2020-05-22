String currentTerm = "none";
String votedFor = "no-one";
List<LogEntry> entries = Collections.emptyList();
try (ObjectInputStream in = new ObjectInputStream(....)) {
    currentTerm = (String) in.readObject();
    votedFor = (String) in.readObject();
    entries = (List<LogEntry>) in.readObject();
}