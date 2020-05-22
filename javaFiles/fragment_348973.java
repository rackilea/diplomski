WebArchive archieve = ShrinkWrap
            .create(WebArchive.class, "myTest.war")
            .addPackages(true, "your.company.project")
            // other resources ...

File[] xstreamLib = Maven.resolver().resolve("com.thoughtworks.xstream:xstream:1.4.7")
            .withTransitivity().asFile();
archieve.addAsLibraries(xstreamLib);