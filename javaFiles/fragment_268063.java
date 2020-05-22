try {
    Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
    XmpDirectory xmpDirectory = metadata.getDirectory(XmpDirectory.class);
    XMPMeta xmpMeta = xmpDirectory.getXMPMeta();
    XMPIterator itr = xmpMeta.iterator();
    while (itr.hasNext()) {
        XMPPropertyInfo pi = (XMPPropertyInfo) itr.next();
        if (pi != null && pi.getPath() != null) {
            if ((pi.getPath().endsWith("stArea:w")) || (pi.getPath().endsWith("mwg-rs:Name")) || (pi.getPath().endsWith("stArea:h")))
                System.out.println(pi.getValue().toString());
        }
    }
} catch (final NullPointerException npe) {
  // ignore
}