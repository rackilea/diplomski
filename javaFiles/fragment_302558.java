@Stateless
public class VisitService implements VisitServiceLocal {

    private VisitDao visitDao;

    @Override
    public List<Visit> findMyVisits(Integer myId) {
        return visitDao.findMyVisits(myId);
    }

}