@Embeddable
public class LigneCommandePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "commande_id")
    private int commandeId;
    @Basic(optional = false)
    @Column(name = "produit_id")
    private int produitId;
}