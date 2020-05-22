Command command = new FooCommand();
JCommander jc = new JCommander(command, args);
jc.setProgramName("foo-command");
StringBuilder builder = new StringBuilder();
jc.usage(builder);
System.out.println(builder);