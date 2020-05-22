public class CustomerRepositoryImpl
 extends QueryDslRepositorySupport
 implements CustomerRepositoryCustom {

    public Iterable<Customer> findAllLongtermCustomersWithBirthday() {
        QCustomer customer = QCustomer.customer;
        return from(customer)
           .where(hasBirthday().and(isLongTermCustomer()))
           .list(customer);
    }
}