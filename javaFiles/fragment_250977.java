public class SecurityPersonal implements Person {

    private String firstName;
    private String lastName;

    @Autowired
    @Qualifier("officeAddress")
    private Address officeAddressSecurity;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getOfficeAddressSecurity() {
        return officeAddressSecurity;
    }

    public void setOfficeAddressSecurity(Address officeAddressSecurity) {
        this.officeAddressSecurity = officeAddressSecurity;
    }

    @Override
    public void printingName() {
        StringBuilder secName = new StringBuilder();
        secName.append("Security Personal Name : ").append(getFirstName()).append(" ").append(getLastName());
        System.out.println(secName.toString());
    }

    @Override
    public void officeAddress() {
        StringBuilder secAddress = new StringBuilder();

        secAddress.append("Office Address : ").append(" State - ").append(getOfficeAddressSecurity().getState())
                .append(" City - ").append(getOfficeAddressSecurity().getCity()).append(" Pincode - ")
                .append(getOfficeAddressSecurity().getPincode()).append("\n");

        System.out.println(secAddress.toString());
    }

    @Override
    public void shippingAddress() {

    }

    @Override
    public void itemsListDetails() {

    }
}