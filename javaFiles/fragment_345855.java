@Repository
public interface ProspectStatistiqueRepository extends JpaRepository<ProspectStatique, Long> {

//1-Between
    public List<ProspectStatique> findByDate_consultationBetween(Date date1,Date date2);

//2-After
    public List<ProspectStatique> findByDate_consultationAfter(Date date);

//3-Befor
    public List<ProspectStatique> findByDate_consultationBefore(Date date);

}