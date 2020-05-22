@ManagedBean(name = "agencyBean")
@RequestScoped
public class AgencyBean {

    private TAgency tEventType = new TAgency();
    private List<TAgency> listAgencies;

    @PostConstruct
    public void init() {
        EntityManager em = HibernateUtil.getEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select u from TAgency u");
        List<TAgency> agencyList = q.getResultList();
        for (TAgency agency : agencyList) {
            System.out.println("NAme: " + agency.gettUser().getName());
        }
    }

    public TAgency gettEventType() {
        return tEventType;
    }

    public void settEventType(TAgency tEventType) {
        this.tEventType = tEventType;
    }

    public List<TAgency> getListAgencies() {
        return listAgencies;
    }

    public void setListAgencies(List<TAgency> listAgencies) {
        this.listAgencies = listAgencies;
    }
}