final SNMPTrap trap = parseTrap(line);
Platfrom.runLater(new Runnable() {
  @Override public void run() {
    model.add(trap);
  }
});