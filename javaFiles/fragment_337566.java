void DrawPen(PGraphics pg, int cptX, int cptY, int r) {
    pg.beginDraw();
    for (int x = 0; x < r; ++x) {
        for (int y = 0; y < r; ++y) {
          float distance = sqrt(x*x + y*y);
          float alpha = 255-map(distance,0,r,0,255);
          if (distance < r) {
              pg.set(cptX+x,cptY+y,color(255,255,255, alpha));
              pg.set(cptX-x,cptY+y,color(255,255,255, alpha));
              pg.set(cptX+x,cptY-y,color(255,255,255, alpha));
              pg.set(cptX-x,cptY-y,color(255,255,255, alpha));
          }
        }
    }
    pg.endDraw();
}