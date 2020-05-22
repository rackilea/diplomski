private static final String APPLICATION_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<application xmlns=\"http://java.sun.com/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/application_6.xsd\" version=\"6\">"            + "<display-name>org.acme.project</display-name>"
        // the WAR must be added to the application.xml !
        + "<module><web><web-uri>test.war</web-uri><context-root>/test</context-root></web></module>"
        + "</application>";

@Deployment
public static Archive<?> createDeployment() {
    EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class);
    ear.setApplicationXML(new StringAsset(APPLICATION_XML));

    // to add the WAR to the application.xml, it must have a name
    WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war");
    // the test class must be added manually for whatever reason
    webArchive.addClass(SomeTest.class);
    ear.addAsModules(Testable.archiveToTest(webArchive));
    return ear;
}