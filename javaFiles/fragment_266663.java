void testStuff() throws Exception {
        File testPom = new File(getBasedir(),"src/test/resources/pom/basic-test-plugin-config.xml");
        assertNotNull(testPom);
        MyPlugin mojo = new MyPlugin();
        mojo = (MyPlugin) configureMojo(
            mojo, extractPluginConfiguration("cue-maven-plugin", testPom
        );
        mojo.execute();
    }