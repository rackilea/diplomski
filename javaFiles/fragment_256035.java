public static void main(String[] args) throws Exception {
    String json = "{ \"Company\": { \"name\": \"cookieltd\", \"type\": \"food\", \"franchise_location\": [ { \"location_type\": \"town\", \"address_1\": \"5street\" }, { \"location_type\": \"village\", \"address_1\": \"2road\" } ] } }";
    ObjectMapper mapper = new ObjectMapper();
    ObjectReader reader = mapper.reader(Company.class).withRootName(
            "Company"); // read after the root name
    Company company = reader.readValue(json);
    System.out.println(company.getFranchise_location().get(0).getAddress_1());
}

public static class Company {
    private String name;
    private String type;
    private List<Location> franchise_location = new ArrayList<Location>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<Location> getFranchise_location() {
        return franchise_location;
    }
    public void setFranchise_location(List<Location> franchise_location) {
        this.franchise_location = franchise_location;
    }
}

public static class Location {
    private String location_type;
    private String address_1;
    public String getLocation_type() {
        return location_type;
    }
    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }
    public String getAddress_1() {
        return address_1;
    }
    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }
}