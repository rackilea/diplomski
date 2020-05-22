@JsonRootName("summary")
class Summary {

    @JsonProperty("somefield1")
    private String someField1;
    private List<Vendor> vendors = new ArrayList<Vendor>();

    @JsonAnySetter
    public void setDynamicProperty(String vendorName, Map<String, String> properties) {
        Vendor vendor = new Vendor();
        vendor.setName(vendorName);
        vendor.setField1(properties.get("field1"));
        vendor.setField2(properties.get("field2"));

        vendors.add(vendor);
    }

    //getters,setters,toString methods

}