@Repository
public class AnneeHibernateDao implements AnneeDao{
    //...
}

@Service
public class AnneeMetierImpl implements AnneeMetier{
    @Autowired
    private AnneeDao anneeDao;
    //...
}