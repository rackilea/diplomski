@ManyToOne(optional=false)
@JoinColumn(name="Companys_list_id", referencedColumnName="id")
private Company company;

@ManyToOne(optional=false)
@JoinColumn(name="Handymans_list_id", referencedColumnName="id")
private Handyman handyman;