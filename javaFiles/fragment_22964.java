HashMap<String, String> test1 = new HashMap<String, String>();
Map root = new HashMap();
test1.put("one", "1");
test1.put("two", "2");
test1.put("three", "3");
root.put("hello", test1);


Configuration cfg = new Configuration(); // Create configuration
Template template = cfg.getTemplate("test.ftl"); // Filename of your template

StringWriter sw = new StringWriter(); // So you can use the output as String
template.process(root, sw); // process the template to output

System.out.println(sw); // eg. output your result