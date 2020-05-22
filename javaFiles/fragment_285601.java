<%
SlingBindings bindings = (SlingBindings) req.getAttribute(SlingBindings.class.getName());
SlingScriptHelper scriptHelper = bindings.getSling();
MyService service = scriptHelper.getService(MyService.class);
// ... do stuff with service.
%>