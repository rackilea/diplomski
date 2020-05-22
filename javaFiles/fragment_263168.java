@Deployment
public static Archive<?> createDeployment() {
    JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "morphological-analysis-data-access-object-test.jar")
    .addPackages(true, "br.com.cpmh.beacon")
    .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
    .addAsResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));

    // print all included packages
    System.out.println(archive.toString(true));

    return archive;
}