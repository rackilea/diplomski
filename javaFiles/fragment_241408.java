VelocityEngine ve = new VelocityEngine();
Template template = ve.getTemplate("name_of_template");
VelocityContext context = new VelocityContext();
StringWriter writer = new StringWriter();

context.put("username", yourUsernameString);
context.put("password", yourPasswordString);

template.merge(context, writer);

// 'writer' now holds the output!
// try using 'writer.toString()' to get a string version.