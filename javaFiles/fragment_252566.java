if (contains(rec1, rec2) || contains(rec2, rec1)) {
        s = "One rectangle is contained in another.";
    } else if (rec1.intersects(rec2.getX(), rec2.getY(), rec2.getWidth(), rec2.getHeight())) {
        s = "One rectangle overlaps another.";
    } else {
        s = "The rectangles do not overlap.";
    }