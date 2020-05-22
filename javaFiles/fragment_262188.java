@Entity
@Table(name = "CAMPAIGNS")
@Audited
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer campaignId;

    @Column(name = "name", nullable = false, unique = true)
    private String campaignName;

     @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
     @JoinTable(name = "CAMPAIGN_PROMOTIONS", 
                joinColumns = { @JoinColumn(name = "campaign_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "promotion_id") })
     private Set<PromotionEntity> promotions;

     ...
}