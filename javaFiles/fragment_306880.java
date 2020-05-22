@Service
public class AsyncMarketService {

    @Inject
    IdentifierManager identifierManager;

    @Inject
    SessionFactory sessionFactory;

    public void getProducts() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            identifierManager.getTitleForIdentifier();
        } catch(Exception e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }
    }
}