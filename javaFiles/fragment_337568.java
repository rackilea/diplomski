void DrawPen(PGraphics pg, int cptX, int cptY, int r, color c) {
    pg.beginDraw();
    pg.clear();
    for (int x = 0; x < r; ++x) {
        for (int y = 0; y < r; ++y) {
          float distance = sqrt(x*x + y*y);
          float alpha = 255-map(distance,0,r,0,255);
          if (distance < r) {
              color pc = color(red(c),green(c),blue(c), alpha);
              pg.set(cptX+x,cptY+y,pc);
              pg.set(cptX-x,cptY+y,pc);
              pg.set(cptX+x,cptY-y,pc);
              pg.set(cptX-x,cptY-y,pc);
          }
        }
    }
    pg.endDraw();
}