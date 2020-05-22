// Load the file
final STGroup stGroup = new STGroupFile("exampleTemplate.stg");

// Pick the correct template
final ST templateExample = stGroup.getInstanceOf("templateExample");

// Pass on values to use when rendering
templateExample.add("param", "Hello World");

// Render
final String render = templateExample.render();

// Print
System.out.println(render);