class GeneralCollectionEntityInfoExt {
    private String BlacklistCode;

    public GeneralCollectionEntityInfoExt() {
    }

    public GeneralCollectionEntityInfoExt(String blacklistCode) {
        this.BlacklistCode = blacklistCode;
    }

    @XmlElement(name = "BlacklistCode")
    public String getBlacklistCode() {
        return this.BlacklistCode;
    }

    public void setBlacklistCode(String blacklistCode) {
        this.BlacklistCode = blacklistCode;
    }
}