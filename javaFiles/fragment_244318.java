@Autowired
CustomerService customerService;

@PostMapping(value = "/customers/create")
public Customer postCustomer(@RequestBody CustomerDto customerDto) {
    Customer _customer = customerService.save(customerDto));
    return _customer;
}