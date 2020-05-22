private static void promotePdfSaveFormat(JasperViewer jasperViewer) {
    /* get via reflection the parameter JasperViewer object's member viewer (of type JRViewer) */
    JRViewer viewer = on(jasperViewer).field("viewer").get();
    /* get via reflection JRViewer object's member tlbToolBar (of type JRViewerToolbar) */
    JRViewerToolbar tlbToolBar = on(viewer).field("tlbToolBar").get();
    /* call tlbToolBar's getSaveContributors() */
    Arrays.stream(tlbToolBar.getSaveContributors())
        /* filter instance of type JRPdfSaveContributor */
        .filter(e -> e instanceof JRPdfSaveContributor)
        /* set JRViewerToolbar object member lastSaveContributor value to the instance of JRPdfSaveContributor */
        .forEach(e -> on(tlbToolBar).set("lastSaveContributor", e));
}