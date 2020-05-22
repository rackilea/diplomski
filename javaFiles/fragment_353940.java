public class LigneCommande implements Serializable {

@EmbeddedId
    protected LigneCommandePK ligneCommandePK;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "status")
    private String status;
    @JoinColumn(name = "produit_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "commande_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
}