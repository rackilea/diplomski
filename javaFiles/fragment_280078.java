@Autowired
    private Dao dao;

   @Transactional(readOnly = true)
    public List<MyEntity> getAll() {
      return dao.getAll(MyEntity.class);
    }