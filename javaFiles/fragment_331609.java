public class LeadAffiliate {  
    @Id
    private Long leadId;  

    @OneToOne @MapsId
    private Lead lead; 

    ...
}