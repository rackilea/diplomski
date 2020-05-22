private void drawLine(GL gl, int x1, int y1, int x2, int y2) {
    gl.glPointSize(1.0f);
    gl.glBegin(GL.GL_POINTS);

    int samples = 100;
    float dx = (x2 - x1) / (float)samples;
    float dy = (y2 - y1) / (float)samples;

    for( int i = 0; i < samples; i++ )
    {
        gl.glVertex2f( i * dx, i * dy );
    } 

    gl.glEnd();//end drawing of points
}