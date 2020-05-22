@Named
@SessionScoped
public class SubjectControllerUpdate implements Serializable {

    private DataModel<Subject> subjects;

    @EJB
    private SubjectFacade ejbFacade;

    @PostConstruct
    public void init() {
        subjects = new ListDataModel<Subject>(ejbFacade.findAll());
    }

    public void save() {
        ejbFacade.save(subjects.getRowData());
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

}