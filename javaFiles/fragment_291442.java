for (GameObject go: gObjects) {
            if (go.getType() == PROJECTILE_ID) {
        go.getVelocity().x = player.getLineEndX() - player.getLineOrgX();
        go.getVelocity().y = player.getLineEndY() - player.getLineOrgY();
        System.out.println(go.getVelocity().x);
        System.out.println(go.getVelocity().y);
            }
        }