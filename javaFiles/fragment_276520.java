private static void initializeLogging()


{  
  //Getting the current timestamp to use in log file naming
  Calendar calendar = Calendar.getInstance();
  java.text.DateFormat df = new java.text.SimpleDateFormat("yyMMddHHmmss");
  String timestamp = df.format(calendar.getTime());

  ConfigurationBuilder< BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

  builder.setStatusLevel(Level.ALL);
  builder.setConfigurationName("RollingBuilder");
  // create a console appender      
  AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").addAttribute("target",
                                                                                                   ConsoleAppender.Target.SYSTEM_OUT);
  appenderBuilder.add(builder.newLayout("PatternLayout")
          .addAttribute("pattern", "<%d{yyyy/MM/dd HH:mm:ss}>  %p (%t).  %m%n"));
  builder.add(appenderBuilder);
  // create a rolling file appender
  LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
          .addAttribute("pattern", "<%d{yyyy/MM/dd HH:mm:ss}>  %p (%t).  %m%n");
  ComponentBuilder triggeringPolicy = builder.newComponent("Policies")              
          .addComponent(builder.newComponent("SizeBasedTriggeringPolicy").addAttribute("size", "100M"));
  //specifying log file name as well ss log file name if the first exceeds maximum size => 100M
  appenderBuilder = builder.newAppender("rolling", "RollingFile")
          .addAttribute("fileName", "logs/myLogging" + "_" + timestamp + ".log")              
          .addAttribute("FilePattern","logs/myLogging"+"_"+ timestamp + "%d{yyyyMMddHHmmss}" + ".log")
          .add(layoutBuilder)
          .addComponent(triggeringPolicy);
  builder.add(appenderBuilder);

  // create the new logger
  builder.add(builder.newLogger("myLogger", Level.ALL)
          .add(builder.newAppenderRef("rolling"))
          .addAttribute("additivity", false));

  builder.add(builder.newRootLogger(Level.ALL)
          .add(builder.newAppenderRef("rolling")));
  LoggerContext ctx = Configurator.initialize(builder.build());      


 }