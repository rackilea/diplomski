public interface MusicRepository extends CrudRepository<Music, Integer> {

List<Music> findByid(int id);

@Query("Select m from Music m where m.filename like '%private' or m.filename like '%public'")
List<Music> findCustom();
}