...
public String test(
    @FormParam("entity") String entityString) {      

    InputStream inputStream = new ByteArrayInputStream(entityString.getBytes());        
    Kunde kunde = new ObjectMapper().read((inputStream, Kunde.class));       

    return "Der Name des Kunden ist: "+kunde.getVorname()+" "+kunde.getNachname();
}