public abstract class AbstractRestController<T, ID extends Serializable> {

    private final JpaRepository<T, ID> repository;  

    public AbstractRestController(JpaRepository<T, ID> repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResponseBody<T>> getOne(@PathVariable ID id) {
        T restObj = repository.findOne(id);
        JsonResponseBody<T> response = new JsonResponseBody<>(ResponseStatus.SUCCESS, restObj);      
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(response);
    }

    protected JpaRepository<T, ID> getRepository(){ return repository; }
}


@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController extends AbstractRestController<Customer, Long> {

    @Autowired
    public CustomerController(CustomerRepository repository){
        super(repository);
    }  

}