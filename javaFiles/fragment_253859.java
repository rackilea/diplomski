class Patient {
    @JsonAdapter(AddressAdapter.class)
    public Address address;
    public String first_name;
    public String last_name;
}