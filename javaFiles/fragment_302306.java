Table table2;
{
    JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    table2 = (Table) unmarshaller.unmarshal(new StringReader(xml));
}
System.out.println(table2);