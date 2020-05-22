@XmlRootElement(name = "contentFiles")
class RtSuperQuickMetadata
{
    private List<RtSuperQuickMetadataItem> rtSuperQuickMetadataItems;

    public RtSuperQuickMetadata()
    {
        rtSuperQuickMetadataItems = new ArrayList<RtSuperQuickMetadataItem>();
    }

    @XmlElement(name = "contentFile")
    public List<RtSuperQuickMetadataItem> getRtSuperQuickMetadataItems()
    {
        return rtSuperQuickMetadataItems;
    }

    public void setRtSuperQuickMetadataItems(
            List<RtSuperQuickMetadataItem> rtSuperQuickMetadataItems)
    {
        this.rtSuperQuickMetadataItems = rtSuperQuickMetadataItems;
    }

}