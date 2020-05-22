@Mapper
public interface CustomerMapper {
    PersonalCustomer personcalCustomerToPersonalCustomer(PersonalCustomer pc);

    default Customer customerToCustomer(Customer customer) {
        if (customer instanceOf PersonalCustomer) {
            return personalCustomerToPersonalCustomer((PersonalCustomer) pc);
        } else if (customer instanceOf BusinessCustomer) {
            return businessCustomerToBusinessCustomer((BusinessCustomer) pc);
        }
    }
}