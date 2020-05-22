@Service
public class BusService {
@Autowired
private BusRepository busRepository;

@PersistenceContext
private EntityManager entityManager;

public void getBus(){
  try{
    entityManager.getTransaction().begin();
    Query query = entityManager.createNativeQuery("SELECT ID, NUMBER , Rote_ID FROM bus", Bus.class);
   busRepository.save(query.getResultList());
   System.out.println(busRepository.toString());
  } finally {
    entityManager.getTransaction().commit();
  }
}