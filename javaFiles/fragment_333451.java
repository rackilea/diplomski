public class ContentServiceImpl implements ContentService {

    @Autowired
    private EntityManager em; // Gets wired in by Spring

    public List<Content> findAllContent() {
        return em.createNamedQuery("Content.findAll").getResultList();
    }

    ...
}