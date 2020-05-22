@Singleton
public class AnotherServiceAdapter implements AnotherService {

    @Autowired
    private AnotherServiceImpl originalService;

    @Override // No transactional here => no aop proxy
    public synchronized Token getToken() {
        // Lock is held before transactional code kicks in
        return originalService.getToken();
    }
}