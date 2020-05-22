AbstractColorChooserPanel[] Panels = chooser.getChooserPanels();
for (AbstractColorChooserPanel panel : Panels) {
    System.out.println(panel.getDisplayName());
    String name = panel.getClass().getSimpleName();
    if (!"DefaultRGBChooserPanel".equals(name))
        tcc.removeChooserPanel(panel);
}