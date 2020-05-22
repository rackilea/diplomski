@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ADDRESS_ID")
private Address address;

@Transient
private PostalAddress postalAddress;