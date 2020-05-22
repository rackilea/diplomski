public class FournisseurDaoImpl implements IFournisseurDao {
    @PersistenceContext
    private EntityManager em;
public void modifierFournisseurJPA(Fournisseurs fournisseur) {
        em.merge(fournisseur);
    }
...
}