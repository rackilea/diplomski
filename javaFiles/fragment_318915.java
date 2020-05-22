DummyEntity entity= new DummyEntity("name");
    entityDao.persist(entity);
    entityDao.flush();
    entityDao.detach(entity);

    final DummyEntity newEntity = entityDao.findById(entity.getId());
    newEntity.setName("Different name");
    entityDao.persist(newEntity);
    entityDao.flush();

    entity.setName("new name");
    entity = entityDao.merge(entity );
    entityDao.persist(entity);