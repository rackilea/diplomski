Vector3 point;
    Body bodyThatWasHit;

    @Override
    public boolean touchDown (int x, int y, int pointer, int newParam) {

        point.set(x, y, 0); // Translate to world coordinates.

        // Ask the world for bodies within the bounding box.
        bodyThatWasHit = null;
        world.QueryAABB(callback, point.x - someOffset, point.y - someOffset, point.x + someOffset, point.y + someOffset);

        if(bodyThatWasHit != null) {
            // Do something with the body
        }

        return false;
    }