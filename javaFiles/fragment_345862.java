aspect ErrorHandler {
  declare soft : Exception : within(*);
  after() throwing(Exception e) : handler(e) {

    // do something...
  }
}