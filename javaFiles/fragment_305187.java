// this is DEPRECATED -----------vvvvvvvvvvvv
class My_OLD_STYLE_Actor extends UntypedActor {
  @Override
  public void onReceive(Object msg) {
    if (msg instanceof RequestMonies) {
      RequestMonies req = (RequestMonies) msg;
      // ...
    } else if (msg instanceof CheckStatus) {
      CheckStatus check = (CheckStatus) msg;
      // ...
    } else unhandled();
  }
}