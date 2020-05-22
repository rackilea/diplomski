@Repository
public class CandidateDao implements ICandidateDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public CandidateModel create(CandidateDto candidate) {
        CandidateModel candidateModel = new CandidateModel(candidate.getFirstName(), candidate.getLastName(), candidate.getEmail(), candidate.getPhone());
        return em.persist(candidateModel);
    }

    @Override
    public CandidateModel show(Long id) {
        return new CandidateModel(
                "new",
                "new",
                "new",
                "new");
    }

    @Override
    public CandidateModel update(Long id, CandidateDto candidate) {
        return new CandidateModel(
                "updated",
                candidate.getLastName(),
                candidate.getEmail(),
                candidate.getPhone());
    }

    @Override
    public void delete(Long id) {

    }
}