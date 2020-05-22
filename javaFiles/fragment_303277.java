@Override
public void act(float delta) {
    if (wasTouched) {
        y += SPEED_WHEN_TOUCHED * delta;
        positionChanged();
    }
}