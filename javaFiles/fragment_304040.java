// Get the action configuration defined in struts.xml
ActionConfig config = invocation.getProxy().getConfig(); 

// Get the SUCCESS result configured for that Action
ResultConfig success = config.getResults().get("success");

// Iterate the Params, friendly printing :)
for (Map.Entry<String, String> entry : success.getParams().entrySet()) {
    System.out.println("<param name=\"" 
                       + entry.getKey() 
                       + "\">"
                       + entry.getValue()
                       + "</param>");
}