protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Context context = new ContextImpl(req, res);
    Action action = ActionFactory.getAction(req); // Do whatever way you do to locate the `Action`.
    action.execute(context);
    context.render(); // Do here whatever you'd initially to do with the obtained Response.
}