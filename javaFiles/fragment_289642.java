private final ChangeListener<Orientation> onOrientationChange = 
    (ObservableValue<? extends Orientation> obs, Orientation ov, Orientation nv) -> {
    if (nv == null || splashPane == null)
        return;
    splashPane.pseudoClassStateChanged(vertical, Orientation.VERTICAL == nv);
    splashPane.pseudoClassStateChanged(horizontal, Orientation.HORIZONTAL == nv);
}

Services.get(OrientationService.class).ifPresent(service -> {
    service.orientationProperty().addListener(onOrientationChange);
});