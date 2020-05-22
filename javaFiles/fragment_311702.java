int mx = x + radius;
int my = y + radius;
double b = 0;
int rad = (int)(radius*1.20);
for( int i = 0 ; i < angle.length ; i++ ) {
    b += angle[i]/2;
    double brad = b*Math.PI/180.0;
    int ix = (int)(rad*Math.cos(brad));
    int iy = (int)(rad*Math.sin(brad));
    g.drawString( Integer.toString(i+1), mx+ix, my-iy );
    b += angle[i]/2;
}