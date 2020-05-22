final Action myAction = new ActionImpl();
myAction.setServlet(getServlet());
/* ONLY if your form enctype is "multipart/request-data". */
myAction.setMultipartRequestHandler(getMultipartRequestHandler());

//Finally
myAction.execute(params);