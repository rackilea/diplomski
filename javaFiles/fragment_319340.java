vectorPart = shoot.getLinearVelocity();
        if ((vectorPart.x > 0 && vectorPart.y < 0) || (vectorPart.x > 0 && vectorPart.y > 0)
                || (vectorPart.x < 0 && vectorPart.y < 0) || (vectorPart.x < 0 && vectorPart.y > 0)) {
            vectorPart = new Vector2(vectorPart.x, vectorPart.y * -1);
        } else {
            vectorPart = new Vector2(vectorPart.x * -1, vectorPart.y * -1);
        }
        shoot.setLinearVelocity(vectorPart.x, vectorPart.y);