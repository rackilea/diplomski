@Test
public void fileTest() throws FileNotFoundException, IOException {

    File file = null;

    Properties props = new Properties();

    props.setProperty("Hello", "World");

    URL url = Thread.currentThread().getContextClassLoader()
            .getResource("exceptions/user.properties");

    try {
        file = new File(url.toURI().getPath());

        assertTrue(file.exists());
    } catch (URISyntaxException e) {

        e.printStackTrace();
    }

    props.store(new FileOutputStream(file), "OMG, It werks!");

}