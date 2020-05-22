return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClasses(
                        TestServiceLocal.class,
                        TestServiceRemote.class,
                        TestServiceImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");