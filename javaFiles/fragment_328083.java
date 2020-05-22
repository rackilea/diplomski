@Component
public class SomeFacade extends AbstractFacade<Some> {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

}