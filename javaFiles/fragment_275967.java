@ManagedBean
@ViewScoped
public class AnneeBean {
    private AnneeMetier anneeMetier;
    private List<Annee> listeAnnees;

    @PostConstruct
    public void init() {
        anneeMetier = new AnneeMetierImpl();
        listeAnnees = anneeMetier.getAllAnnees();
    }

    public List getListeAnnees() {
        return listeAnnees;
    }

    public void setListeAnnees(List listeAnnees) {
        this.listeAnnees = listeAnnees;
    }

    public AnneeMetier getAnneeMetier() {
        return anneeMetier;
    }

    public void setAnneeMetier(AnneeMetier anneeMetier) {
        this.anneeMetier = anneeMetier;
    }
}