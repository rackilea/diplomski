class YourClass {
    @Inject
    private RestClient restClient;    //Injecting RestClient

    public Address getOfficeLocation(String id){
        String url = String.format(officeAddress, id);
        JSONObject jsonObject = restClient.get(url, null, credentials);
        return AddressParser.parseOfficeAddress(jsonObject);
    }
}