public class EntityRepositoryTest {

    @Autowired
    EntityJPARepository EntityRepo;

    Entity entity;

    @Before
    public void setup() {
         if (entity == null) { // true only for first pass
             entity = //initializes entity with values
             EntityRepo.save(entity);
         }
    }    

    //some tests on repo

 }