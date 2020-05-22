new Comparator<LoggerConfig>() {
  @Override
  public int compare(LoggerConfig o1, LoggerConfig o2) {
    return (o1.getName().compareTo(o2.getName()));
  }
};