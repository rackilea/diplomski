protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Request request = new RequestImpl(req, res);
    Action action = ActionFactory.getAction(req); // Do whatever way you do to locate the `Action`.
    Response = action.get(request);
    // ...
}