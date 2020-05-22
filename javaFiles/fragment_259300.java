@Autowired
private EntityManager entityManager;

@PostMapping("")
@Transactional
public void add(@RequestBody MyClass myClass){
        entityManager.persist(myClass);
}