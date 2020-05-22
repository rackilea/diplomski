temp.addAction(Actions.sequence(
    Actions.touchable(Touchable.disabled),
    rotL,
    rotR,
    rotBack,
    Actions.touchable(Touchable.enabled)
));