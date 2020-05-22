@Service
@Transactional
public class TheService {
  private static final Logger log = LoggerFactory.getLogger(TheService.class);

  private TheRepository repository;

  public TheService(final TheRepository repository) {
    this.repository = repository;
  }

  @Transactional(readOnly = true)
  public Collection<JpaEntity> searchAll() {
    log.info("Retrieving all records...");
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<JpaEntity> searchById(final UUID id) {
    log.info("Retrieving record with ID [{}]", id);
    return repository.findById(id);
  }

  public JpaEntity save(final JpaEntity entity) {
    log.info("Persisting record [{}]", entity);
    return repository.save(entity);
  }
}