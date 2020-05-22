public interface SeasonRepository extends CrudRepository<Season, Long> {

    @Query("SELECT id, name FROM Season")
    List<SeasonIdName> findAllSeasons();

}