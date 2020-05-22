PGraphics pg;
PGraphics pg_pen;
int rad = 20;

void setup (){
    size(800, 800, P2D);

    pg = createGraphics(800, 800, JAVA2D);
    pg.beginDraw();
    // [...]
    pg.endDraw();

    pg_pen = createGraphics(2*rad, 2*rad, JAVA2D);
    DrawPen(pg_pen, rad, rad, rad);
}