@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    List<T> findAll( );
    Optional<T> findById(ID id);
    @Query("SELECT t FROM #{#entityName} t WHERE t.id IN :ids")
    List<T> findByIdsIn(@Param("ids") List<ID> ids);
}