@Override
protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest    request, HttpServletResponse response) throws Exception {

// Expose the model object as request attributes.
     exposeModelAsRequestAttributes(model,request);

// Determine the path for the request dispatcher.
String dispatcherPath = prepareForRendering(request, response);

// set original view being asked for as a request parameter
request.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));

// force everything to be template.jsp
RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/template.jsp");
requestDispatcher.forward(request, response);

System.out.println("**********************"+model.get("userName"));
}

}