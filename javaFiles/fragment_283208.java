@ElementCollection
@CollectionTable(name="HRM_USER_USER_PROFILE", joinColumns=@JoinColumn(name="id_profile"))
@AttributeOverrides({
          @AttributeOverride(name="type", 
                             column=@Column(name="TYPE"))
        })
private Set<UserProfile> userProfiles = new HashSet<UserProfile>(0);