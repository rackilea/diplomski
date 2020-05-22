spriteBatch.draw(
            getCurrentTextureRegion(),
            getPosition().x + xOffset - center.x,
            getPosition().y + yOffset - center.y,
            center.x, center.y,
            getCurrentFrameAnimation().getFrameWidth(), getCurrentFrameAnimation().getFrameHeight(),
            1.0f, 1.0f,
            rotationDeg
    );