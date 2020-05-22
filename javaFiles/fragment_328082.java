@Service
@EnableTransactionManagement
public class StoreAssociateService {

    @Autowired
    HibernateUtil hb;
    SessionFactory sessionFactory ;
    @PostConstruct
    public void init()
    {
        sessionFactory = hb.getFactory();
    }

}