List<T> findAll();
    List<T> findAll(Sort sort);
    List<T> findAllById(Iterable<ID> ids);
    <S extends T> List<S> saveAll(Iterable<S> entities);
    <S extends T> S saveAndFlush(S entity);
    void deleteAllInBatch();
    <S extends T> List<S> findAll(Example<S> example);