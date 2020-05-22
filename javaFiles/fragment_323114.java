@XmlRootElement(name = "BlacklistCodeSet")
class BlackListCode {
    private ClEntityIdInfoExt clEntityIdInfoExt;
    private GeneralCollectionEntityInfoExt generalCollectionEntityInfoExt;

    @XmlElement(name = "ClEntityIdInfoExt")
    public ClEntityIdInfoExt getClEntityIdInfoExt() {
        return this.clEntityIdInfoExt;
    }

    public void setClEntityIdInfoExt(ClEntityIdInfoExt clEntityIdInfoExt) {
        this.clEntityIdInfoExt = clEntityIdInfoExt;
    }

    @XmlElement(name = "GeneralCollectionEntityInfoExt")
    public GeneralCollectionEntityInfoExt getGeneralCollectionEntityInfoExt() {
        return this.generalCollectionEntityInfoExt;
    }

    public void setGeneralCollectionEntityInfoExt(GeneralCollectionEntityInfoExt generalCollectionEntityInfoExt) {
        this.generalCollectionEntityInfoExt = generalCollectionEntityInfoExt;
    }

    @Override
    public String toString() {
        return "BlackListCode{entityId='" + this.clEntityIdInfoExt.getEntityId() + '\'' +
                           ", BlacklistCode='" + this.generalCollectionEntityInfoExt.getBlacklistCode() + '\'' + '}';
    }
}