for (int i = 0; i < points.size(); i += 2) {

    PVector p1 = points.get(i);
    boolean even = i+1 < points.size();
    PVector p2 = even ? points.get(i+1) : new PVector(mouseX, mouseY);

    line(p1.x, p1.y, p2.x, p2.y);
}