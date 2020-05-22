import eu.medsea.mimeutil.MimeUtil2;

try {
    final MimeUtil2 mimeUtil = new MimeUtil2();
        mimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");

    return MimeUtil2.getMostSpecificMimeType(mimeUtil.getMimeTypes(basePath + "/" + fileName)).toString();
} catch (final Exception exception) {
    return "<EXCEPTION: " + exception.getMessage() + ">";
}