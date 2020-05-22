@Inject @Any
private Instance<ControllerBaseClass> controllerInstance;

(...)

ControllerBaseClass controller = controllerInstance.select(«something»).get();
controller.processRequest(); // or execute() or anything you want.
request.getRequestDispatcher(«page»).forward(request, response); // or a redirect if it's a destructive operation.