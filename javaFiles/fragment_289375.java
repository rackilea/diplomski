Vector a = (targetLoc).toVector().subtract(player.getLocation().toVector()).normalize();
        Vector b = player.getLocation().getDirection();
        angle = Math.acos(a.dot(b));
        angle = Math.toDegrees(angle);
        if(a.getX()*b.getZ() - a.getZ()*b.getX() < 0) {
            angle = -angle;
        }