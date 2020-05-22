String name = "mytemplate";
String source = "hi ${name}";
Template template = new GroovyTemplateCompiler().compile(new GroovyTemplate(name, source)));
Map<String,Object> args = new HashMap<String,Object>();
args.put("name","mom");
String renderedHtml = template.render(args);