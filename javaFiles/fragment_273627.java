sRenderer.begin(ShapeType.Filled);
sRenderer.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
sRenderer.identity();
sRenderer.translate(pos.x, pos.y, 0);
sRenderer.rotate(0, 0, 1, getBody().getAngle() * 60.0f);
sRenderer.rect(-getWidth(), -getHeight(), getWidth() * 2, getHeight() * 2);
sRenderer.end();