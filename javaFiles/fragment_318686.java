@Test
void test() throws JAXBException {
    AgencyOrUnit agencyOrUnit = new AgencyOrUnit();
    agencyOrUnit.setPrimaryValue(new LocaleString("el", "ΓΑΔΑ"));
    agencyOrUnit.setAlternativeSpelling(new LocaleString("en", "General Police"));

    JAXBContext ctx = JAXBContext.newInstance(AgencyOrUnit.class);

    Marshaller marshaller = ctx.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    marshaller.marshal(agencyOrUnit, System.out);
}