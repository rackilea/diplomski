private static void createAppearances() {
    normalAppearance = new Appearance();
    normalAppearance.setMaterial(normalMaterial);
    selectedAppearance = new Appearance();
    selectedAppearance.setMaterial(selectedMaterial);
    TransparencyAttributes ta = new TransparencyAttributes();

    ta.setTransparencyMode (TransparencyAttributes.BLENDED);
    ta.setTransparency (DEFAULT_HISTOGRAM_ALPHA);

    normalAppearance.setTransparencyAttributes (ta);
    selectedAppearance.setTransparencyAttributes(ta);
}