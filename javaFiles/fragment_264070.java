// Post the LogRecord to all our Handlers, and then to
// our parents' handlers, all the way up the tree.

Logger logger = this;
while (logger != null) {
    Handler targets[] = logger.getHandlers();

    //...

    if (!logger.getUseParentHandlers()) {
      break;
    }

    logger = logger.getParent();
}
}