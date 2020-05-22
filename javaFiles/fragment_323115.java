class ClEntityIdInfoExt {
    private String entityId;

    public ClEntityIdInfoExt() {
    }

    public ClEntityIdInfoExt(String entityId) {
        this.entityId = entityId;
    }

    @XmlElement(name = "EntityId")
    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}