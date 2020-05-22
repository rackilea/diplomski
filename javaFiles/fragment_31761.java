public Area calculateHitboxArea() {
    Area area = new Area();
    for(int i = 0; i < getMass(); i++) {
        Block block = getBlock(i);
        area.add(new Area(new Rectangle(block.getX() - 1, block.getY() - 1, 3, 3)));
    }
    return area;
}