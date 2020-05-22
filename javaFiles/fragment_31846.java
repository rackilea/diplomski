@ApiMethod(name = "echo")
public Message echo(HttpServletRequest req, Message message, @Named("n") @Nullable Integer n) {

  String remote = req.getRemoteAddr();

  return doEcho(message, n);
}