if (r3.intersects(r4)) {
        System.out.println("Wall hit, move back");
        pacman.setDx(-pacman.getDx());
        pacman.setDy(-pacman.getDy());
        // Possibly need to call move() here again.
        pacman.move();
        break;
    }