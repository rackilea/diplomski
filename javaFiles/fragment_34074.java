@RequestMapping(value = Connectors.CONNECTOR_HEARTBEAT, method = RequestMethod.POST)
public void doSomething(@RequestBody List<Message> messages, HttpServletResponse response) {
    int code = (messages!=null && !messages.isEmpty()) ? HttpServletResponse.SC_OK
            : HttpServletResponse.SC_NOT_FOUND;
    if (code != HttpServletResponse.SC_OK) {
        response.sendError(code, res);
        return;
    }
    java.io.PrintWriter wr = response.getWriter();
    response.setStatus(code);
    wr.print(res);
    wr.flush();
    wr.close();

    // Now it it time to do the long processing
    ...
}