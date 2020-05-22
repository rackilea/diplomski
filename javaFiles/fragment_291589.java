public void process(request, response) {
    View view = new View(request, response);
    Action action = ActionFactory.getAction(request);
    if (action != null) action.execute(view);
    view.navigate();
}