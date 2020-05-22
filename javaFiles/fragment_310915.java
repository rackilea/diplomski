@Entity
public class CampaignCountry implements Serializable {

    @EmbeddedId
    private CampaignCountryPK id;

    @MapsId("campaignId")
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private CampaignEntity campaignEntity;
}

@Embeddable
public class CampaignCountryPK implements Serializable {

    @Column(name = "campaign_id")
    private long campaignId;
    @Column(name = "country")
    private String country;
}

@Entity
@Table(name = "campaign_country")
public class CampaignCountry implements Serializable {

    @EmbeddedId
    private CampaignCountryPK id;

    @MapsId("campaignId")
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private CampaignEntity campaignEntity;
}