interface ProductRepository<T extends Product> extends CrudRepository<T, Long> {

    @Query("select p from #{#entityName} p where ?1 member of p.categories")
    Iterable<T> findByCategory(String category);

    Iterable<T> findByName(String name);
}