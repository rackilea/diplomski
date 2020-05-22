ServiceName ejbDependency = ServiceName.of("jboss", "deployment", "subunit", "my-ear.ear", "my-module.jar", "component", "MyTimerBean", "START");
singleton.build(new DelegatingServiceContainer(context.getServiceTarget(), context.getServiceRegistry()))
                 .addDependency(ServerEnvironmentService.SERVICE_NAME, ServerEnvironment.class, service.getEnvironment())
                 .setInitialMode(Mode.ACTIVE)
                 .addDependency(ejbDependency)
                 .install();