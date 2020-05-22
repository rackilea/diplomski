@ManyToOne
@JoinColumns({ 
    @JoinColumn(name = "broadcast_date", insertable = false, updatable = false),
    @JoinColumn(name = "campaign_id", insertable = false, updatable = false)     
})
private CampaignBroadcast broadcast;