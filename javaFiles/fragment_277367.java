CompilerConfiguration config=new CompilerConfiguration();
config.setClasspath("autotest");
config.addCompilationCustomizers(new ImportCustomizer());
GroovyShell shell=new GroovyShell(config);
Binding binding = new Binding();
binding.setVariable("args",null);
System.out.println(((AutotestResult)shell.run(new File("autotest/cases/test.groovy"),new ArrayList())).toJSON());