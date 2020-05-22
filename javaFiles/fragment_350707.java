class MyService {
  @Autowired
  ViewEntityRepository viewEntityRepository;

  @Autowired
  TableEntityRepository tableEntityRepository;

  @PersistenceContext
  EntityManager entityManager

  @Transactional
  ViewEntity updateTableEntity(String newStatus, TableEntity tableEntity) {
      ViewEntity ret = viewEntityRepository.findBySharedId(tableEntity.SharedId);
      tableEntity.status = newStatus;
      tableEntityRepository.saveAndFlush(viewEntity);
      entityManager.refresh(ret)
      return ret;
  }
}