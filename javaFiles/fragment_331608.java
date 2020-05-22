public class Lead { 
    @Id @GeneratedValue
    private Long leadId; 

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lead")
    private LeadAffiliate leadAffiliate; 

    ...
}