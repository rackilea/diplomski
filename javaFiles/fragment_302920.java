try {
    ClipboardService cs =
    (ClipboardService)ServiceManager.lookup("javax.jnlp.ClipboardService");
    img = (Image)cs.getContents().getTransferData(DataFlavor.imageFlavor);
} catch (Exception ex) {
}