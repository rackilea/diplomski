@Service
public class Controller {
    @Autowired
    private Store storeImpl;

    public void use() {
       storeImpl.get();
    }
}