@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    /*@Query("select p from Projet p")
    public List<Projet> findAllProjets();*/
}