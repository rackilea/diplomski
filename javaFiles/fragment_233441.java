@Service
public class FooService {

    private final FooDao fooDao;

    public FooService(FooDao fooDao) {
        this.fooDao = fooDao;
    }
}