public class CustomerProperties {
    private List<Integer> id = new ArrayList<>();
    private List<String> country = new ArrayList<>();
    private List<Integer> customerId = new ArrayList<>();
    private List<String> name = new ArrayList<>();
    private List<String> surname = new ArrayList<>();
    private List<Date> dateOfBirth = new ArrayList<>();

    public void add(Customer c) {
        id.add(c.getId());
        country.add(c.getCountry());
        customerId.add(c.getCustomerId());
        name.add(c.getName());
        surname.add(c.getSurname());
        dateOfBirth.add(c.getDateOfBirth());
    }
    public void add(CustomerProperties c) {
        id.addAll(c.id);
        country.addAll(c.country);
        customerId.addAll(c.customerId);
        name.addAll(c.name);
        surname.addAll(c.surname);
        dateOfBirth.addAll(c.dateOfBirth);
    }
}