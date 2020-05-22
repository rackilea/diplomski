@ManagedBean
public class MyManagedBean {

    private List<Parent> parentList;//+getter
    private Map<Long, Long> relatedChildrenB = new HashMap<Long,Long>();//+getter
    @EJB
    private ParentFacade parentFacade;

    @PostConstruct
    public void init() {
        parentList = parentFacade.findAll();
        for (Parent parent : parentList) {
            relatedChildrenB.put(parent.getId(), parentFacade.getNumberOfRelatedChildrenB(parent));
        }

}