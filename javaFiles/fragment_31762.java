Area area1 = chunk1.calculateHitboxArea();
Area area2 = chunk2.calculateArea();
area1.intersect(area2);
if(!area1.isEmpty()) {

    // Collision stuff here

}