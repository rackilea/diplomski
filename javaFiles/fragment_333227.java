import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SomeServiceImpl implements SomeService {

    private final SomeRepository repository;
    private final EntityManager entityManager;

    // constructor, autowiring

    @Override
    public void someMethod(long id) {
        SomeEntity getOne = repository.getOne(id); // Proxy -> added to cache

        entityManager.detach(getOne); // removes getOne from the cache

        SomeEntity findById = repository.findById(id).get(); // Entity from the DB
    }