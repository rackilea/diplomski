@Service
public class BulkService {

    @PersistenceContext
    private EntityManager em;

    // @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize = 20;

    private List<Entity> savedEntities;

    public Collection<Entity> bulkSave(List<Entity> entities) {
        int size = entities.size();
        savedEntities = new ArrayList<>(size);

        try {
            for (int i = 0; i < size; i += batchSize) {
                int toIndex = i + (((i + batchSize) < size) ? batchSize : size - i);
                processBatch(entities.subList(i, toIndex));
                em.flush();
                em.clear();
            }
        } catch (Exception ignored) {
            // or do something...  
        }
        return savedEntities;
    }

    @Transactional
    protected void processBatch(List<Entity> batch) {

        for (Entity t : batch) {
            Entity result;
            if (t.getId() == null) {
                em.persist(t);
                result = t;
            } else {
                result = em.merge(t);
            }
            savedEntities.add(result);
        }
    }
}