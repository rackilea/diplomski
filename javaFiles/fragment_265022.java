application = new SpringApplicationBuilder()
    .parent(new Object[]{"classpath:file1.xml", "classpath:file2.xml"})
    .profiles("abc")
    .properties("key1:test1", "key2:test2") 
    .showBanner(false)
    .logStartupInfo(true)
    .headless(true)
    .application()
    .run();