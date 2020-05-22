private Tooltip createBoundTooltip(final String key) {
    Tooltip tooltip = new Tooltip();
    tooltip.textProperty().bind(Bindings.createStringBinding( 
         () -> Utils.i18n(key), Utils.localeProperty()));
    return tooltip ;
}