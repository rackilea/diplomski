@Entity class MerchantMerchantTypeAssociation {

    @EmbeddedId
    private MerchantMerchantTypeAssociationPk id;

    @ManyToOne
    @JoinColumns({
         @JoinColumn(name = "e1_id", referencedColumnName = "e1_id",...),
         @JoinColumn(name = "e2_id", referencedColumnName = "e2_id",...)
    })
    @MapsId("merchantTypePK") // <<< *attribute* in Embeddable
    private MerchantType merchantType;

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "merchant_id",...)
    @MapsId("merchantPK") // <<< *attribute* in Embeddable
    private Merchant merchant;
}