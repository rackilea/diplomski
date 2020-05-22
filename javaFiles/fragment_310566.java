static {
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.ALL);
    Logger log = LogManager.getLogManager().getLogger("");
    log.addHandler(handler);
    log.setLevel(Level.ALL);
}