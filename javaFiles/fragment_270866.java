// Strip the call to pacman.move() prior to this point.

Rectangle r3 = pacman.getOffsetBounds(); // Check against the candidate position.

for (int j = 0; j<barriers.size(); j++) {
    Barrier b = (Barrier) barriers.get(j);
    Rectangle r4 = b.getBounds();

    if (r3.intersects(r4)) {
        System.out.println("Wall hit");
        pacman.setDx(0);
        pacman.setDy(0);
        // Quit the loop. It's pointless to check other barriers once we hit one.
        break;
    }
}
// Now we're good to move only in case there's no barrier on our way.
pacman.move();