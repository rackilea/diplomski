@Service
@Scope("prototype")
public class MyService<T extends AbstractMyDao>{

    @Autowired
    private T myDao;
}