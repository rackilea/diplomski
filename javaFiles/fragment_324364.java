@Service
public class CustomerServiceImpl implements CustomerService {

    ...

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDaoImpl.saveCustomer(customer);
    }

    ...
}