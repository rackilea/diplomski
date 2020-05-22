private void updatePaperSource() {
    Media m = (Media)printReqAttrSet.get(Media.class);
    if (m instanceof MediaTray) {
        PaperSource s = j2dPrinter.getPaperSource((MediaTray)m);
        if (s != null) {
            settings.setPaperSource(s);
        }
    }
}