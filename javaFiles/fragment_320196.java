public String getPerson(){
    Person personPOJOInstance = new Person();
    ObjectMapper mapper = new ObjectMapper();
    StringWriter sw = new StringWriter();

    try{
        mapper.writeValue(sw, personPOJOInstance);
        pojoJSON = sw.getBuffer().toString();
    }
    catch(IOException exc){

    }
    return pojoJSON;
}