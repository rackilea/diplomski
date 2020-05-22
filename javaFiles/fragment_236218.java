if (Gdx.input.isTouched())
    {
        Vector3 tmp = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        touch_target = new Vector2(tmp.x, tmp.y);
    }

    touch_angleWant = Rot2D.fromVector(
        touch_target.x - entity_player.getBody().getPosition().x,
        touch_target.y - entity_player.getBody().getPosition().y
    );

    double cross1 = Rot2D.cross(touch_angleCur, touch_angleWant);

    if (cross1 > 0.0)
        touch_angleCur.rotate(Rot2D.fromDegrees(5.0));
    else
        touch_angleCur.rotate(Rot2D.fromDegrees(-5.0));

    double cross2 = Rot2D.cross(touch_angleCur, touch_angleWant);

    if (Math.signum(cross1) != Math.signum(cross2))
        touch_angleCur.load(touch_angleWant);

     entity_player.getBody().setTransform(entity_player.getBody().getPosition(), (float) (touch_angleCur.getAngle()));