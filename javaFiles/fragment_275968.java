@Component
@Scope("view")
public class AnneeBean {
    @Autowired
    private AnneeMetier anneeMetier;
    private List<Annee> listeAnnees;

    @PostConstruct
    public void init() {
        listeAnnees = anneeMetier.getAllAnnees();
    }

    public List getListeAnnees() {
        return listeAnnees;
    }

    public void setListeAnnees(List listeAnnees) {
        this.listeAnnees = listeAnnees;
    }
}