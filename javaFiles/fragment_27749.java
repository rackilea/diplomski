@Deployment
public static Archive<?> createDeployment() {

return ShrinkWrap.create(WebArchive.class, "test.war")
        (...)
        .addAsLibraries(libs)
        // Add in below way any additional file to the archive
        .addAsResource("path-to-testset.xml", "dbunit/testset.xml")
        .addPackage("de.abc.RuleEditor")
        .addAsResource("de/abc/RuleEditor/messages.properties", "messages.properties")
        .addAsManifestResource("test-jboss-deployment-structure.xml","jboss-deployment-structure.xml")
        (...)
}