EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class);
ear.addAsModules(
    org.jboss.arquillian.container.test.api.Testable.archiveToTest(
        ShrinkWrap.createFromZipFile(WebArchive.class, new File("lib/module1-4.4.2.war"));
ear.addAsModules(new File("lib/module2-3.7.0.jar"));
ear.addAsModules(new File("lib/module3-3.7.war"));