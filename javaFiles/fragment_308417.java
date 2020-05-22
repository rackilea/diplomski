for (int i = 0; i < collidables.size(); i++) {
        Entity e1 = collidables.get(i);

        for (int j = i + 1; j < collidables.size(); j++) {
            Entity e2 = collidables.get(j);

            if (e1.isColliding(e2)) {
                CollisionHandler handler = ... // get handler if registered for type of e1 vs type of e2
                if (handler != null)
                    handler.onCollision(e1, e2);
            }
        }
    }