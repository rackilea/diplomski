private function move(PBClass pb1, PBClass pb2, BClass b) {
    if (pb1.getTileX() == b.getTileX() & pb1.getTileY() == b.getTileY()) {
        if (b.getbUp() == 1 & pb1.getTileY() - 1 != pb2.getTileY()) {
            pb1.move(0, -1);
        } else if (b.getbDown() == 1
                & pb1.getTileY() + 1 != pb2.getTileY()) {
            pb1.move(0, 1);
        } else if (b.getbRight() == 1
                & pb1.getTileX() + 1 != pb2.getTileX()) {
            pb1.move(1, 0);
        } else if (b.getbLeft() == 1
                & pb1.getTileX() - 1 != pb2.getTileX()) {
            pb1.move(-1, 0);
        }
    }
}

public void pb1TouchingBaddy() {
    move(pb1, pb2, b1);
    move(pb1, pb2, b2);
    move(pb1, pb2, b3);
    move(pb1, pb2, b4);
}