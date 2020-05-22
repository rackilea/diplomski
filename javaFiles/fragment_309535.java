@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
@JoinColumn(name = "portal_logo_id", referencedColumnName = "id", nullable = true)
private PortalResourceModel logo;

@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
@JoinColumn(name = "portal_favicon_id", referencedColumnName = "id", nullable = true)
private PortalResourceModel favicon;