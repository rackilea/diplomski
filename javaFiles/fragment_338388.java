InputStream groovyClassIS = GroovyCompiler.class
     .getResourceAsStream("/org/jboss/loom/tools/groovy/Foo.groovy");

GroovyClassLoader gcl = new GroovyClassLoader();
Class clazz = gcl.parseClass(groovyClassIS, "SomeClassName.groovy");
Object obj = clazz.newInstance();
IFoo action = (IFoo) obj;
System.out.println( action.foo());