public static CountryDataResponse javaSevenMode(String jsonString) 
    throws PropertyException, JAXBException {

    Unmarshaller unmarshaller = JAXB_CONTEXT.createUnmarshaller();
    unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
    unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);

    StringReader sr = new StringReader(jsonString);
    JsonReader jsonReader = Json.createReader(sr);
    JsonArray rootArray = jsonReader.readArray();

    JsonObject paginationInfoJO = rootArray.getJsonObject(0);
    JsonStructureSource paginationInfoJSS = new JsonStructureSource(paginationInfoJO);
    PaginationInfo pi = unmarshaller.unmarshal(paginationInfoJSS, PaginationInfo.class).getValue();

    JsonArray dataJArray = rootArray.getJsonArray(1);
    JsonStructureSource dataArrayJSS = new JsonStructureSource(dataJArray);
    List<Data> datas
            = (List<Data>) unmarshaller.unmarshal(dataArrayJSS, Data.class)
            .getValue();

    DataArray da = new DataArray();
    da.setDatas(datas);

    CountryDataResponse cdr = new CountryDataResponse();
    cdr.setDataArray(da);
    cdr.setPaginationInfo(pi);

    return cdr;
}