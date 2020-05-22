@PersistenceContect
   EntityManager em;

   @Transactional
    public MyObject create(MyObject myObject) {
        this.myObjectRepository.saveAndFlush(myObject);
        em.clear(); //force reload from database
        return this.myObjectRepository.findById(createdMyObject.getMyObjectId());
    }