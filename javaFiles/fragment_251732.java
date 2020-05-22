Optional<List<LogDetails>> logDetailsOpt = logLine.getSomeProperty() 
                       .map(this::extractLogDetails)
                       .filter(list -> !list.isEmpty());

if (!logDetailsOpt.isPresent()) {
  logError(logLine);
}