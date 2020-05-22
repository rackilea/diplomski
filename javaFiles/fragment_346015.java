// Lastly, the default servlet for root content
// It is important that this is added last.
String defName = "default"; // the important "default" name
ServletHolder holderDef = new ServletHolder(defName, DefaultServlet.class);
holderDef.setInitParameter("dirAllowed","true");
ctx.addServlet(holderDef,"/"); // the servlet spec "default url-pattern"