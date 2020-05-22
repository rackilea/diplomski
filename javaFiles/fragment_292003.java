ConfigurationBuilder< BuiltConfiguration > builder =
        ConfigurationBuilderFactory.newConfigurationBuilder();

builder.setStatusLevel( Level.ERROR);
builder.setConfigurationName("RollingBuilder");
// create the console appender
AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").addAttribute("target",
        ConsoleAppender.Target.SYSTEM_OUT);
appenderBuilder.add(builder.newLayout("PatternLayout").
        addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
builder.add( appenderBuilder );

LayoutComponentBuilder layoutBuilder = builder.newLayout("PatternLayout")
        .addAttribute("pattern", "%d [%t] %-5level: %msg%n");
ComponentBuilder triggeringPolicy = builder.newComponent("Policies")
        .addComponent(builder.newComponent("CronTriggeringPolicy").addAttribute("schedule", "0 0 0 * * ?"))
        .addComponent(builder.newComponent("SizeBasedTriggeringPolicy").addAttribute("size", "100M"));
appenderBuilder = builder.newAppender("rolling", "RollingFile")
        .addAttribute("fileName", "target/rolling.log")
        .addAttribute("filePattern", "target/archive/rolling-%d{MM-dd-yy}.log.gz")
        .add(layoutBuilder)
        .addComponent(triggeringPolicy);
builder.add(appenderBuilder);

// create the new logger
builder.add( builder.newLogger( "TestLogger", Level.DEBUG )
        .add( builder.newAppenderRef( "rolling" ) )
        .addAttribute( "additivity", false ) );

builder.add( builder.newRootLogger( Level.DEBUG )
        .add( builder.newAppenderRef( "rolling" ) ) );
Configurator.initialize(builder.build());