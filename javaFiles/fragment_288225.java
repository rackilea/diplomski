@Override
protected void updateXmpMetadata() {
    // Do not forget to call the method of the base class!
    super.updateXmpMetadata();
    try {
        XMPMeta meta = XMPMetaFactory.parseFromBuffer(getXmpMetadata(true));
        // Here we remove the unwanted entry from the metadata
        meta.deleteProperty(XMPConst.NS_XMP, PdfConst.ModifyDate);
        setXmpMetadata(meta);
    } catch (XMPException e) {
    }
}