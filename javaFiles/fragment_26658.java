void updateGame(float deltaTime) {
    float step = deltaTime;
    do (
        Collision hit = findFirstCollision(step);
        if (hit != null) {
            step = Math.max(hit.time, MIN_STEP);
            updateObjects(step);
            updateVelocities(hit);
        } else {
            updateObjects(step);
        }
        deltaTime -= step;
        step = deltaTime;
    } while (deltaTime > 0);
}

/**
 * Finds the earliest collision that occurs within the given time
 * interval. It uses the current position and velocity of the objects
 * at the start of the interval. If no collisions occur, returns null.
 */
Collision findFirstCollision(float deltaTime) {
    Collision result = null;
    for (int i = 0; i < obj_list.length; ++i) {
        for (int j = i + 1; j < obj_list.length; ++j) {
            Collision hit = findCollision(i, j, deltaTime);
            if (hit != null) {
                if (result == null || hit.time < result.time) {
                    result = hit;
                }
            }
        }
    }
    return result;
}

/**
 * Calculate if there is a collision between obj_list[i1] and
 * obj_list[i2] within deltaTime, given their current positions
 * and velocities. If there is, return a new Collision object
 * that records i1, i2, the direction of the hit, and the time
 * at which the objects collide. Otherwise, return null.
 */
Collision findCollision(int i1, int i2, float deltaTime) {
    // left as an exercise for the reader
}

/**
 * Move every object by its velocity * step
 */
void updateObjects(float step) {
    for (GameObject obj : obj_list) {
        Point2D.Float pos = obj.getPosition();
        Point2D.Float velocity = obj.getVelocity();
        obj.setPosition(
            pos.getX() + step * velocity.getX(),
            pos.getY() + step * velocity.getY()
        );
    }
}

/**
 * Update the velocities of the two objects involved in a
 * collision. Note that this does not always reverse velocities
 * along the direction of collision (one object might be hit
 * from behind by a faster object). The algorithm should assume
 * that the objects are at the exact position of the collision
 * and just update the velocities.
 */
void updateVelocities(Collision collision) {
    // TODO - implement some physics simulation
}