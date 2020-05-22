import javax.ejb.EJB;

public class VeranstaltungBO {

    @EJB
    private Dao<Veranstaltung> veranstaltungDao;

    public Veranstaltung getVeranstaltungById(long id){
       // Line below is number 20
       return veranstaltungDao.findById(Veranstaltung.class, id);
    }
}