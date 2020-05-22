@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    // change save to return saved customer
    @Override
    public Customer save(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        // customer.setTicket(customerDto.getTicket()); // remove this

        List<Ticket> tickets = new ArrayList<>();
        for (TicketDto ticketDto : customerDto.getTicketDtos) {
            Ticket ticket = new Ticket();
            ticket.setDestinationCity(ticketDto.getDepartureCity());
            ticket.setDestinationCity(ticketDto.getDestinationCity());
            tickets.add(ticket);
        }
        customer.setTickets(tickets); // add this to set tickets on customer
        return repository.save(customer);
    }