...
public String test(
    @FormParam("entity") String entityString) {      

    InputStream inputStream = new ByteArrayInputStream(entityString.getBytes());        
    Kunde kunde = JAXB.unmarshal(inputStream, Kunde.class);       

    return "Der Name des Kunden ist: "+kunde.getVorname()+" "+kunde.getNachname();
}