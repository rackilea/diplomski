@Test
public void unmarshallsCatalog() throws JAXBException, IOException {

    JAXBContext context = JAXBContext.newInstance(Catalog.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    try (InputStream is = Thread.currentThread()
                              .getContextClassLoader()
                              .getResourceAsStream("catalog.xml")) {

        Catalog catalog = unmarshaller.unmarshal(new StreamSource(is), Catalog.class).getValue();
        Assert.assertEquals(catalog.books.size(), 12);

    }
}