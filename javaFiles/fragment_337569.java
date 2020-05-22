void mousePressed() {
    color c = pg.get(mouseX, mouseY);
    println(c);

    DrawPen(pg_pen, rad, rad, rad, c);
}