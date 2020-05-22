@Service
public class FooService {

    private final EntityManager entityManager;

    @Autowired
    public FooService(@Qualifier("orderEntityManager") EntityManager entityManager) {
        ...
    }

}