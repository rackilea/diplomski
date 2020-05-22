@Service
@Transactional
public class CandidateService implements ICandidateService{

    @Autowired
    ICandidateDao candidateDao;

    @Override
    public CandidateModel create(CandidateDto candidate) {
        CandidateModel candidateModel = new CandidateModel(candidate.getFirstName(), candidate.getLastName(), candidate.getEmail(), candidate.getPhone());
        return candidateDao.save(candidate);
    }

    @Override
    public CandidateModel show(Long id) {
        return candidateDao.findOne(id);
    }

    @Override
    public CandidateModel update(Long id, CandidateDto candidate) {
        CandidateModel cm = candidateDao.findOne(id);
        // Update values.
        return candidateDao.save(cm);
    }

    @Override
    public void delete(Long id) {
        candidateDao.delete(id);
    }
}