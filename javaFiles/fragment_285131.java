for (ItemType item : items) {

        hasX = hasX || doesHaveX(item);
        hasY = hasY || doesHaveY(item);
        hasZ = hasZ || doesHaveZ(item);

        if (hasX && hasY && hasZ) {

            break;
        }
    }