@Id
@SequenceGenerator(name="att_id", sequenceName="attendee_setup_id_seq", initialValue = 1, allocationSize = 1)

@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="att_id")

@Column(name="PARTNER_PROPERTY_ID")
private int PARTNER_PROPERTY_ID;