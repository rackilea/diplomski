@Test
    public void readFile() throws Exception {
        InputStream inputStream = MaestroTest.class.getClassLoader().getResourceAsStream("folder/file.json");
        String data = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(data);
    }