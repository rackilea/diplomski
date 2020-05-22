@OneToMany
@JoinColumn(
    name = "defaultTask"
)
public List<Resource> getrelatedResources() {
    return m_relatedResources;
}